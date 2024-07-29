import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12869 뮤탈리스크
public class Main {
    //가능한 공격의 경우의 수
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    static int[] scv = new int[3];
    static int[][][] dp = new int[61][61][61];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(mutal(scv[0], scv[1], scv[2])); //뮤탈의 공격 횟수 dfs & dp
    }

    static int mutal(int one, int two, int three) {
        if (one <= 0 && two <= 0 && three <= 0) {
           return 0; //종료 조건 -> 모든 scv 파괴
        }

        if (dp[one][two][three] != 0) {
            return dp[one][two][three];
        }

        int tmp = 999999;
        for (int i = 0; i < 6; i++) {
            tmp = Math.min(tmp, mutal(Math.max(one - attack[i][0], 0),
                    Math.max(two - attack[i][1], 0), Math.max(three - attack[i][2], 0)) + 1);
        }
        return dp[one][two][three] = tmp;
    }
}