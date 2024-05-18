import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정복자
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

    static int n, m, t, min, cnt;
    static ArrayList<Node>[] lists;
    static boolean[] visit;
    static boolean isAdd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

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

        visit = new boolean[n + 1];
        mst(); //최소 신장 트리
        System.out.println(min);
    }

    static void mst() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visit[current.node]) {
                visit[current.node] = true;
                min += current.weight;

                if (isAdd) {
                    min += (cnt * t);
                    cnt++;
                }
                isAdd = true;

                for (Node next : lists[current.node]) {
                    if (!visit[next.node]) {
                        queue.add(new Node(next.node, next.weight));
                    }
                }
            }
        }
    }
}
