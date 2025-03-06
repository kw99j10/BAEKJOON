import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4811 알약
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[31];
        dp[0] = 1;
        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // 카탈란 수 점화식
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}