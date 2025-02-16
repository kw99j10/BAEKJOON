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
        int[] dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 4 - dp[i - 4];
        }
        System.out.println(dp[n]);
    }
}