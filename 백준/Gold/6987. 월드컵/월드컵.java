import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6987 월드컵
public class Main {
    static class Team {
        int win, draw, lose;
        public Team(int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }

    static Team[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {

            boolean isPossible = true;
            team = new Team[6];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                team[j] = new Team(win, draw, lose);

                if (win + draw + lose != 5) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible && (!checkSum() || !backtracking(0, 1, 0))) {
                isPossible = false;
            }
            sb.append(isPossible ? 1 : 0).append(" ");
        }
        System.out.print(sb);
    }

    static boolean checkSum() {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int j = 0; j < 6; j++) {
            sum1 += team[j].win;
            sum2 += team[j].draw;
            sum3 += team[j].lose;
        }
        return (sum1 + sum2 + sum3 == 30) && (sum1 == sum3) && (sum2 % 2 == 0);
    }

    static boolean backtracking(int cur, int nxt, int cnt) {
        if (cnt == 15) return true; // 총 경기 수: 15

        if (nxt == 6) return backtracking(cur + 1, cur + 2, cnt); // 다음 조합

        if (team[cur].win > 0 && team[nxt].lose > 0) {
            team[cur].win--;
            team[nxt].lose--;
            if (backtracking(cur, nxt + 1, cnt + 1)) return true;
            team[cur].win++;
            team[nxt].lose++;
        }

        if (team[cur].draw > 0 && team[nxt].draw > 0) {
            team[cur].draw--;
            team[nxt].draw--;
            if (backtracking(cur, nxt + 1, cnt + 1)) return true;
            team[cur].draw++;
            team[nxt].draw++;
        }

        if (team[cur].lose > 0 && team[nxt].win > 0) {
            team[cur].lose--;
            team[nxt].win--;
            if (backtracking(cur, nxt + 1, cnt + 1)) return true;
            team[cur].lose++;
            team[nxt].win++;
        }
        return false;
    }
}
