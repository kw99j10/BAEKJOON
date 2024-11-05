import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 3066 브리징 시그널
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[] dp = new int[n];
            dp[0] = arr[0];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                int idx = Arrays.binarySearch(dp, 0, cnt, arr[i]);
                idx = idx < 0 ? -(idx + 1) : idx;
                dp[idx] = arr[i];
                if (idx == cnt) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}