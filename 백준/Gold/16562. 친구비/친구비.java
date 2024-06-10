import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16562 친구비
public class Main {
    static int n, m, k;
    static int[] parents;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        money = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        boolean[] visited = new boolean[n + 1];
        long sum = 0;
        for (int i = 1; i <= n; i++) {

            // 친구 무리 개수 => 방문 여부 판단
            if (!visited[find(i)]) {
                visited[find(i)] = true;
                int min = Integer.MAX_VALUE;

                for (int j = 1; j <= n; j++) {
                    if (find(i) == find(j)) {
                        min = Math.min(min, money[j]);
                    }
                }
                sum += min;
            }
        }
        System.out.println(sum > k ? "Oh no" : sum);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (money[find(a)] < money[find(b)]) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}