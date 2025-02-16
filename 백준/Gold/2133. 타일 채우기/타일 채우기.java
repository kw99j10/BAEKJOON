import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2133 타일 채우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 != 0) {
            System.out.println(0);
            return; // 가로가 홀수일 경우 채울 수 없음
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                int sum = 0;
                for (int j = 0; j < i - 3; j++) {
                    sum += dp[j] * 2;
                }
                dp[i] = sum + dp[i - 2] * 3;
            }
        }
        System.out.println(dp[n]);
    }
}