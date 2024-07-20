import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2240 자두나무
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] tree = new int[t + 1][3]; //1 or 2 (자두 위치)
        int[][][] dp = new int[t + 1][3][w + 1]; // + 움직임 횟수
        for (int i = 1; i <= t; i++) {
            int place = Integer.parseInt(br.readLine());
            tree[i][place] = 1;
        }

        dp[1][1][0] = tree[1][1];
        dp[1][2][1] = tree[1][2];

        for (int i = 2; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                // 움직이거나 유지하거나
                dp[i][1][j] = dp[i - 1][1][j] + tree[i][1];
                dp[i][2][j] = dp[i - 1][2][j] + tree[i][2];
                if (j > 0) {
                    dp[i][1][j] = Math.max(dp[i][1][j], dp[i - 1][2][j - 1] + tree[i][1]);
                    dp[i][2][j] = Math.max(dp[i][2][j], dp[i - 1][1][j - 1] + tree[i][2]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= w; i++) {
            max = Math.max(max, Math.max(dp[t][1][i], dp[t][2][i]));
        }
        System.out.println(max);
    }
}