import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//16202 MST 게임
public class Main {
    static int n, m, k;
    static int[] parents;
    static class Graph implements Comparable<Graph> {
        int x, y, weight;
        public Graph(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        PriorityQueue<Graph> queue = new PriorityQueue<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new Graph(a, b, i));
        }

        StringBuilder sb = new StringBuilder();
        int turn = 0; //턴이 지나면 가중치가 가장 작은 간선 제거
        for (int i = 0; i < k; i++) {

            //매 턴 초기화 필요
            parents = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parents[j] = j;
            }

            int count = 0;
            int min = 0;
            boolean isPossible = true;

            if (turn >= 1) {
                queue.poll();
            }

            PriorityQueue<Graph> tmp = new PriorityQueue<>(queue);
            while (!tmp.isEmpty()) {
                Graph current = tmp.poll();
                int x = current.x;
                int y = current.y;
                int cost = current.weight;
                if (find(x) != find(y)) {
                    union(x, y);
                    min += cost;
                    count++;
                }
            }
            if (count != n - 1) {
                isPossible = false; //최소 스패닝 트리가 존재하지 않음
            }
            turn++;
            sb.append(isPossible ? min : 0).append(" ");
        }
        System.out.print(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents[b] = a;
        }else{
            parents[a] = b;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }else {
            return parents[x] = find(parents[x]);
        }
    }
}