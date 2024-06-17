import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5582 공통 부분 문자열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] subS = s.toCharArray();
        String t = br.readLine();
        char[] subT = t.toCharArray();

        int[][] dp = new int[subS.length + 1][subT.length + 1];
        for (int i = 1; i <= subS.length; i++) {
            for (int j = 1; j <= subT.length; j++) {
                if (subS[i - 1] == subT[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= subS.length; i++) {
            for (int j = 1; j <= subT.length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.print(max);
    }
}