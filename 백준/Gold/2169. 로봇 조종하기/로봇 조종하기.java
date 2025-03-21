import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][m + 2];
        for (int j = 1; j <= m; j++) {
            dp[1][j] = dp[1][j - 1] + grid[1][j];
        }

        for (int i = 2; i <= n; i++) {
            int[] left = new int[m + 2]; // 왼 -> 오
            int[] right = new int[m + 2]; // 오 -> 왼

            left[1] = dp[i - 1][1] + grid[i][1];
            for (int j = 2; j <= m; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + grid[i][j];
            }

            right[m] = dp[i - 1][m] + grid[i][m];
            for (int j = m - 1; j >= 1; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + grid[i][j];
            }

            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
