import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//호석이 두 마리 치킨
public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] road = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(road[i], INF);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a][b] = 1;
            road[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        road[i][j] = 0;
                    }
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }

        int idx1 = 0;
        int idx2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += Math.min(road[i][k] + road[k][i], road[j][k] + road[k][j]);
                }
                if (min > sum) {
                    idx1 = i;
                    idx2 = j;
                    min = sum;
                }
            }
        }
        System.out.println(idx1 + " " + idx2 + " " + min);
    }
}