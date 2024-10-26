import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15661 링크와 스타트
public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] team;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        team = new int[n][n];
        visit = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0);
        System.out.println(min);
    }

    static void comb(int idx) {
        if (idx == n) {
            int sCnt = 0; //스타트팀 능력치
            int lCnt = 0; //링크팀 능력치
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i] && visit[j]) {
                        sCnt += team[i][j];
                    } else if (!visit[i] && !visit[j]) {
                        lCnt += team[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sCnt - lCnt));
            return;
        }
        visit[idx] = true;
        comb(idx + 1);
        visit[idx] = false;
        comb(idx + 1);
    }
}