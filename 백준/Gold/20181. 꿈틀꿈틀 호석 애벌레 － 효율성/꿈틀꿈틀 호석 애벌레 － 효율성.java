import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20181 꿈틀꿈틀 호석 애벌레 - 효율성
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n + 1];
        long sum = 0L;
        int left = 1, right = 1;
        while (right <= n) {
            sum += value[right];

            while (left <= right && k <= sum) {
                long energy = (int) (sum - k); // 탈피 에너지
                dp[right] = Math.max(dp[right], dp[left - 1] + energy);
                sum -= value[left++];
            }
            dp[right] = Math.max(dp[right], dp[right - 1]);
            right++;
        }
        System.out.println(dp[n]);
    }
}