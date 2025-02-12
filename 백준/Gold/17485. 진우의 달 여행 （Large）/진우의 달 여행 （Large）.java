import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17485 진우의 달 여행
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];
        for (int j = 0; j < m; j++) {
            Arrays.fill(dp[0][j], grid[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 왼쪽
                dp[i][j][0] = (j > 0) ? Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + grid[i][j] : Integer.MAX_VALUE;

                // 아래
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];

                // 오른
                dp[i][j][2] = (j < m - 1) ? Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + grid[i][j] : Integer.MAX_VALUE;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                result = Math.min(result, dp[n - 1][j][d]);
            }
        }
        System.out.println(result);
    }
}
