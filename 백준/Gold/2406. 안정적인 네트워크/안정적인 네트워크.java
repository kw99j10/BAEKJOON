import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2406 안정적인 네트워크
public class Main {
    static class Graph {
        int start, end, cost;

        public Graph(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        // 연결된 컴퓨터
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                
                // 본사 컴퓨터를 제외한 mst 
                if (i != j && i != 1 && j != 1) {
                    queue.add(new Graph(i, j, cost));
                }
            }
        }

        int min = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Graph current = queue.poll();
            if (find(current.start) != find(current.end)) {
                union(current.start, current.end);
                min += current.cost;
                count++;
                sb.append(current.end).append(" ").append(current.start).append("\n");
            }
        }
        if (count == 0) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(min + " " + count);
            System.out.print(sb);
        }
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