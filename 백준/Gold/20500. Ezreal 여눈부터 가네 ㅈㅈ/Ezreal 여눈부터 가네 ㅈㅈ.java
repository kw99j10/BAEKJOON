import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20500 Ezreal 여눈부터 가네 ㅈㅈ
public class Main {
    static final int INF = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1516];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i - 1] % INF * 2 + 1) % INF;
            } else {
                dp[i] = (dp[i - 1] % INF * 2 - 1) % INF;
            }
        }
        System.out.println(dp[n] % INF);
    }
}