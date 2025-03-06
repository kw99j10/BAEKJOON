import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11066 파일 합치기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 소설 장 수
            int[] arr = new int[k + 1];
            int[] sum = new int[k + 1]; // 연속된 파일의 합 비용

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            int[][] dp = new int[k + 1][k + 1]; // i~j 까지 합친 최소 비용
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j + i <= k; j++) {
                    dp[j][i + j] = Integer.MAX_VALUE;
                    for (int s = j; s < i + j; s++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][s] + dp[s + 1][i + j] + sum[i + j] - sum[j - 1]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.print(sb);
    }
}