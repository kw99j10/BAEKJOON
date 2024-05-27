import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 14284 간선 이어가기 2
public class Main {
    static class Node implements Comparable<Node> {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int n, m, s, t;
    static ArrayList<Node>[] lists;
    static int[] distance;
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        distance[s] = 0;
        dijkstra(s);
        System.out.println(distance[t]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(new Node(start, 0));
        visit[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visit[current.node]) {
                visit[current.node] = true;
            }

            for (Node next : lists[current.node]) {
                if (distance[next.node] > distance[current.node] + next.weight) {
                    distance[next.node] = distance[current.node] + next.weight;
                    queue.add(next);
                }
            }
        }
    }
}