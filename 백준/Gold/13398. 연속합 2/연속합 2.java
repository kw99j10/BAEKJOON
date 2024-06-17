import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13398 연속합 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 제거하지 않는 경우 && 하나를 제거하는 경우
        int[][] dp = new int[n + 1][2];
        dp[1][0] = num[1];
        dp[1][1] = num[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(num[i], dp[i - 1][0] + num[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + num[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);
    }
}