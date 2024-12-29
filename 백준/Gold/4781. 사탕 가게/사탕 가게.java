import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4781 사탕 가게
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            if (n == 0 && m == 0.00) {
                break;
            }

            int k = (int) (m * 100 + 0.5); // 오차를 위하여 0.5 하고 int 캐스트 필요

            int[] calorie = new int[n + 1];
            int[] price = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(st.nextToken());
                price[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }

            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (j - price[i] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - price[i]] + calorie[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            sb.append(dp[n][k]).append("\n");
        }
        System.out.print(sb);
    }
}
