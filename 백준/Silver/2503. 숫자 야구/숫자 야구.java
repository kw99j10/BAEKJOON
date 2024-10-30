import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2503 숫자 야구
public class Main {
    static class BaseBall {
        int first, second, third, strike, ball;

        public BaseBall(int first, int second, int third, int strike, int ball) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static ArrayList<BaseBall> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            lists.add(new BaseBall(num.charAt(0) - '0', num.charAt(1) - '0'
                    , num.charAt(2) - '0', strike, ball));
        }

        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            String tmp = String.valueOf(i);
            int first = tmp.charAt(0) - '0';
            int second = tmp.charAt(1) - '0';
            int third = tmp.charAt(2) - '0';

            //숫자 야구는 다 다른 숫자 && 0 포함 x
            if (first == second || first == third || second == third || first == 0 || second == 0 || third == 0) {
                continue;
            }
            answer += check(first, second, third);
        }
        System.out.println(answer);
    }

    // strike, ball 체크
    static int check(int first, int second, int third) {

        boolean isPossible = true;
        for (BaseBall list : lists) {

            int sCnt = 0;
            int bCnt = 0;

            int a = list.first;
            int b = list.second;
            int c = list.third;

            if (a == first) {
                sCnt++;
            } else if (b == first || c == first) {
                bCnt++;
            }


            if (b == second) {
                sCnt++;
            } else if (a == second || c == second) {
                bCnt++;
            }

            if (c == third) {
                sCnt++;
            } else if (a == third || b == third) {
                bCnt++;
            }

            if (sCnt != list.strike || bCnt != list.ball) {
                isPossible = false;
                break;
            }
        }
        return isPossible ? 1 : 0;
    }
}