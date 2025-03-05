import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9252 LCS 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        System.out.println(dp[s.length()][t.length()]);
        if (dp[s.length()][t.length()] == 0) {
            return;
        }

        int x = s.length();
        int y = t.length();
        StringBuilder tmp = new StringBuilder();

        // 좌, 우 값 비교
        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y - 1]) {
                y--;
            } else{
                tmp.append(s.charAt(x - 1));
                x--;
                y--;
            }
        }
        System.out.println(tmp.reverse());
    }
}