import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2352 반도체 설계
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
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
        System.out.println(cnt);
    }
}