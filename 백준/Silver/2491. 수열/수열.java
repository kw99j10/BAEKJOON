import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2491 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if (arr[i] >= arr[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 1;
        for (int i = 1; i < n; i++) {
            dp2[i] = 1;
            if (arr[i - 1] >= arr[i]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            } else {
                dp2[i] = 1;
            }
            max = Math.max(max, dp2[i]);
        }
        System.out.println(max);
    }
}