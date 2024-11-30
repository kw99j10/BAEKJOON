import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2688 줄어들지 않아
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j] + sum;
                sum += dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += dp[num][j];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}