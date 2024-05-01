import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주사위 쌓기
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dice = new int[n][7]; //1~6

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        //1번 주사위 경우의 수
        for (int i = 1; i <= 6; i++) {
            int bottom;
            int top = dice[0][top(i)];

            int sum = 0;
            for (int j = 0; j < n; j++) {

                int max = 0; //옆 면의 최댓값
                for (int k = 1; k <= 6; k++) {
                    if (dice[j][k] == top) {
                        bottom = top;
                        top = dice[j][top(k)];

                        for (int s = 1; s <= 6; s++) {
                            if (s == top || s == bottom) {
                                continue;
                            }
                            max = Math.max(max, s);
                        }
                        break;
                    }
                }
                sum += max;
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    static int top(int i) {
        switch (i) {
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 1;
        }
        return -1;
    }
}