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
        int node, price;

        public Node(int node, int price) {
            this.node = node;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return o.price - this.price;
        }
    }

    static int n, m, a, b, c, min = 0;
    static ArrayList<Node>[] lists;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            lists[s].add(new Node(e, p));
            lists[e].add(new Node(s, p));
        }

        dijkstra(a, b, c);
        System.out.println(distance[b] == Integer.MAX_VALUE ? -1 : min);
    }

    static void dijkstra(int start, int end, int cut) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(new Node(start, 0));
        visit[start] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.node == end) {
                break;
            }

            if (!visit[current.node]) {
                visit[current.node] = true;
            }

            for (Node next : lists[current.node]) {
                int price = current.price + next.price;
                if (price > cut) {
                    continue;
                }

                if (distance[next.node] > current.price + next.price) {
                    distance[next.node] = current.price + next.price;
                    min = Math.max(min, next.price);
                    queue.add(new Node(next.node, distance[next.node]));
                }
            }
        }
    }
}