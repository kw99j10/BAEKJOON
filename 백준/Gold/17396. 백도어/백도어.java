import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17396 백도어
public class Main {
    static int n, m;

    static class Node implements Comparable<Node> {
        int node;
        long time;

        public Node(int node, long time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.time - o.time);
        }
    }

    static long[] distance;
    static int[] road;
    static ArrayList<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        road = new int[n]; // 분기점(0: 안보임, 1: 보임)
        distance = new long[n]; // 최소 시간
        lists = new ArrayList[n]; // 연결 여부

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }
        road[n - 1] = 0; // 시야에 보이면서 갈 수 있음

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, time));
            lists[b].add(new Node(a, time));
        }

        shortPath();
    }

    static void shortPath() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        distance[0] = 0;
        queue.add(new Node(0, 0)); // 0에서 시작

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.node == n - 1) {
                System.out.println(current.time);
                return;
            }

            if (current.time > distance[current.node]) {
                continue; // 시간 초과 방지
            }

            for (Node next : lists[current.node]) {
                if (distance[next.node] > current.time + next.time && road[next.node] == 0) { // 시야에도 없어야 하는 조건 추가
                    distance[next.node] = current.time + next.time;
                    queue.add(new Node(next.node, distance[next.node]));
                }
            }
        }
        System.out.println(-1); // 도달할 수 없음
    }
}