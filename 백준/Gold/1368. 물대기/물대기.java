import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1368 물대기
public class Main {
    static class Graph implements Comparable<Graph> {
        int start;
        int end;
        int weight;

        public Graph(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph o) {
            return this.weight - o.weight;
        }
    }

    static int n;
    static int[] cost;
    static int[] parents;
    static PriorityQueue<Graph> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());

                //우물을 최소 하나 이상 파야함 (0번 논 연결)
                if (i == j) {
                    queue.add(new Graph(0, i, cost[i]));
                } else {
                    queue.add(new Graph(i, j, num));
                }
            }
        }

        int min = 0;
        while (!queue.isEmpty()) {
            Graph current = queue.poll();
            int a = current.start;
            int b = current.end;
            int weight = current.weight;

            if (find(a) != find(b)) {
                union(a, b);
                min += weight;
            }
        }
        System.out.println(min);
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

    static int find(int v) {
        if (parents[v] == v) {
            return v;
        } else {
            return parents[v] = find(parents[v]);
        }
    }
}