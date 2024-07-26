import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 9344 도로
public class Main {
    static class Road implements Comparable<Road>{
        int x, y, weight;

        public Road(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }

    static int n, m, p, q;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            PriorityQueue<Road> queue = new PriorityQueue<>();
            int count = 0;
            for (int s = 0; s < m; s++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken()); // 양방향 도로 (u,v)
                int w = Integer.parseInt(st.nextToken()); // 비용 w
                queue.add(new Road(u, v, w));
            }

            boolean isPossible = false;
            while (!queue.isEmpty()) {
                Road current = queue.poll();
                int x = current.x;
                int y = current.y;

                if (find(x) != find(y)) {
                    if ((x == p && y == q) || (x == q && y == p)) {
                        isPossible = true;
                    }
                    union(x, y);
                    count++;
                }
            }

            if (count == n - 1 && isPossible) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }
}