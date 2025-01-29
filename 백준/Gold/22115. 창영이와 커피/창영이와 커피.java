import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 22115 창영이와 커피
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] c = new int[n + 1]; // 카페인 함유량
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        if (k == 0) {
            System.out.println(0); // 마실 커피 필요 x
            return;
        }

        int[] dp = new int[k + 1]; // 횟수
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= c[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - c[i]] + 1);
            }
        }
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}