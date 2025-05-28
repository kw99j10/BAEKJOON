import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 20168 골목대장 호석
public class Main {
    static class Node implements Comparable<Node> {
        int node, max, total;

        public Node(int node, int max, int total) {
            this.node = node;
            this.max = max;
            this.total = total;
        }

        @Override
        public int compareTo(Node o) {
            return this.max - o.max; // 최대 요금을 최소화
        }
    }

    static int n, m, a, b, c, min = Integer.MAX_VALUE;
    static ArrayList<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            lists[s].add(new Node(e, p, p));
            lists[e].add(new Node(s, p, p));
        }

        dijkstra(a, b, c);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dijkstra(int start, int end, int cut) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(new Node(start, 0, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.node == end) {
                min = Math.min(min, current.max);
                break;
            }

            if (visit[current.node]) {
                continue;
            }
            visit[current.node] = true;

            for (Node next : lists[current.node]) {
                int nextSum = current.total + next.total;
                int max = Math.max(current.max, next.total);

                if (cut >= nextSum) {
                    queue.add(new Node(next.node, max, nextSum));
                }
            }
        }
    }
}