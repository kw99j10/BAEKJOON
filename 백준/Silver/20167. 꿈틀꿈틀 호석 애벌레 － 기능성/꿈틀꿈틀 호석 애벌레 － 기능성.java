import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20167 꿈틀꿈틀 호석 애벌레 - 기능성
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

        int[] dp = new int[n + 1];
        int sum = 0;
        int left = 1, right = 1;
        while (right <= n) {
            sum += value[right];

            while (left <= right && k <= sum) {
                int energy = sum - k; // 탈피 에너지
                dp[right] = Math.max(dp[right], dp[left - 1] + energy);
                sum -= value[left++];
            }
            dp[right] = Math.max(dp[right], dp[right - 1]);
            right++;
        }
        System.out.println(dp[n]);
    }
}