import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//민준이와 마산 그리고 건우
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

    static final int INF = 999999;
    static int v, e, p;
    static ArrayList<Node>[] lists;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        lists = new ArrayList[v + 1];
        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        int answer = dijkstra(1, v);
        int tmp = dijkstra(1, p) + dijkstra(p, v);
        System.out.println(answer == tmp ? "SAVE HIM" : "GOOD BYE");
    }

    static int dijkstra(int start, int end) {
        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        visit[start] = true;
        distance[start] = 0;

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
        return distance[end];
    }
}
