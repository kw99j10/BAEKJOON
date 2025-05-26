import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 21278 호석이 두 마리 치킨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(grid[i], 999999);
            grid[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grid[a][b] = 1;
            grid[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        int n1 = 0, n2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += Math.min(grid[i][k] + grid[k][i], grid[j][k] + grid[k][j]);
                } // 왕복 시간

                if (min > sum) {
                    n1 = i;
                    n2 = j;
                    min = sum;
                }
            }
        }
        System.out.println(n1 + " " + n2 + " " + min);
    }
}