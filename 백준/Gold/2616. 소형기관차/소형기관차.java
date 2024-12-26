import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2616 소형기관차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n + 1]; // 객차에 있는 손님 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // 최대 연속으로 끌 수 있는 객차 수
        int[] succession = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            succession[i] += succession[i - 1] + count[i];
        }

        int[][] dp = new int[4][n + 1]; // 소형 기관차, 객차 수
        for (int i = 1; i <= 3; i++) {
            for (int j = i * m; j <= n; j++) {
                int mSum = succession[j] - succession[j - m];
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + mSum);
            }
        }
        System.out.println(dp[3][n]);
    }
}
