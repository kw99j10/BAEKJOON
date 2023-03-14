import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 15990 1, 2, 3 더하기 5 -dp
 *
 */
public class onetwothree {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        final int k=1000000009;

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[100001][4]; //합과 끝나는 수를 표현

        //합이 1이고 끝 숫자가 1
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int j = 4; j <= 100000; j++) {
            //[1 or 2 or 3을 더하기 전의 합][1 or 2 or 3 중 어떤 수로 끝나는지]
            //예를들어 dp[j][1]은 마지막에 1이 오므로 그 전에 1이 와서는 안된다. 따라서 2 or 3으로 끝나야 한다.
            dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % k;
            dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % k;
            dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % k;
        }

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % k).append("\n");
        }
        System.out.print(sb);
    }
}
