import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백양로 브레이크
public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] road = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(road[i], INF);
            road[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            road[u][v] = 0;
            road[v][u] = (b == 0) ? 1 : 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(road[s][e]).append("\n");
        }
        System.out.print(sb);
    }
}