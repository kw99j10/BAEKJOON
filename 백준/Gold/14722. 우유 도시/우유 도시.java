import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14722 우유 도시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] city = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                // 맨 처음
                if (city[i][j] == 0 && dp[i][j] == 0) {
                    dp[i][j] = 1;
                }

                if (dp[i - 1][j] > 0 && city[i][j] == (dp[i - 1][j] % 3)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
                }

                if (dp[i][j - 1] > 0 && city[i][j] == (dp[i][j - 1] % 3)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}