import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//12852 1로 만들기 2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[n]);

        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        while (n != 1) {
            int k = n - 1;
            if (n % 3 == 0 && dp[n] > dp[n / 3]) {
                k = n / 3;
            }
            if (n % 2 == 0 && dp[n] > dp[n / 2]) {
                k = n / 2;
            }
            n = k;
            sb.append(n).append(" ");
        }
        System.out.print(sb);
    }
}