import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n + 1]; //앱의 메모리 바이트 수
        int[] cost = new int[n + 1]; //비활성화 비용

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            total += cost[i];
        }

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[n + 1][total + 1]; //비용당 범위
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= total; j++) { //최소 비용이 0일 경우
                dp[i][j] = dp[i - 1][j];

                if (j - cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                }

                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}