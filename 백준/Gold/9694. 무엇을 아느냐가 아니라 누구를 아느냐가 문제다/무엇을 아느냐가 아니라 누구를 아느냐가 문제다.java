import java.io.*;
import java.util.*;

// 9694
class Main {
    static class Node implements Comparable<Node> {
        int node, like;

        public Node(int node, int like) {
            this.node = node;
            this.like = like;
        }

        @Override
        public int compareTo(Node o) {
            return this.like - o.like;
        }
    }

    static int n, m, isCan = -1;
    static ArrayList<Node>[] lists;
    static int[] prev;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            lists = new ArrayList[m + 1];
            for (int i = 0; i <= m; i++) {
                lists[i] = new ArrayList<>();
            }

            prev = new int[m + 1];
            distance = new int[m + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                lists[x].add(new Node(y, z));
                lists[y].add(new Node(x, z));
            }

            ArrayList<Integer> cases = new ArrayList<>();
            isCan = -1;
            dijkstra();

            int maximum = m - 1; // 최고의원
            while (maximum != 0) {
                cases.add(maximum);
                maximum = prev[maximum];
            }

            Collections.reverse(cases);
            sb.append("Case #").append(t + 1).append(": ");
            if (isCan == 1) {
                sb.append(0);
                for (Integer aCase : cases) {
                    sb.append(" ").append(aCase);
                }
            } else {
                sb.append(-1).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[m + 1];
        distance[0] = 0;
        visit[0] = true;
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.node == m - 1) {
                isCan = 1;
                return;
            }

            if (!visit[current.node]) {
                visit[current.node] = true;
            }

            for (Node next : lists[current.node]) {
                if (distance[next.node] > current.like + next.like) {
                    distance[next.node] = current.like + next.like;
                    prev[next.node] = current.node;
                    queue.add(new Node(next.node, distance[next.node]));
                }
            }
        }
    }
}