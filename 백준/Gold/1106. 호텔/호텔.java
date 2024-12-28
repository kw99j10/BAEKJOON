import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1106 호텔
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cost = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            count[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][1000001]; // 최대 상한선
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 1000000; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - cost[i]] + count[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            if (dp[n][i] >= c) {
                System.out.println(i);
                return;
            }
        }
    }
}
