import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17835 면접보는 승범이네
public class Main {
    static class Node implements Comparable<Node> {
        int node;
        long distance;

        public Node(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    static int n, m, k;
    static ArrayList<Node>[] lists;
    static long[] distance;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        distance = new long[n + 1]; //
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[v].add(new Node(u, c)); // 역방향 최단 거리
        }

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int spot = Integer.parseInt(st.nextToken());
            pq.add(new Node(spot, 0)); // 면접장
            distance[spot] = 0;
        }

        dijkstra();

        int node = 0;
        long maxDistance = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                node = i;
                maxDistance = distance[i];
            }
        }
        System.out.println(node);
        System.out.println(maxDistance);
    }

    static void dijkstra() {
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.distance > distance[current.node]) {
                continue; // 최단 거리가 아님
            }

            for (Node next : lists[current.node]) {
                if (distance[next.node] > next.distance + current.distance) {
                    distance[next.node] = next.distance + current.distance;
                    pq.add(new Node(next.node, distance[next.node]));
                }
            }
        }
    }
}