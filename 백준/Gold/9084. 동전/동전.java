import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9084 동전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = arr[i]; j <= m; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.print(sb);
    }
}