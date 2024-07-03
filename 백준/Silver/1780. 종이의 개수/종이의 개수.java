import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1780 종이의 개수
public class Main {
    static int minus, zero, plus;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(n, 0, 0);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void divide(int n, int x, int y) {

        boolean flag = false; //다른 숫자를 판별하는 변수
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != paper[x][y]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (!flag) {
            if (paper[x][y] == -1) {
                minus++;
                return;
            } else if (paper[x][y] == 0) {
                zero++;
                return;
            } else {
                plus++;
                return;
            }
        }

        divide(n / 3, x, y);
        divide(n / 3, x, y + n / 3);
        divide(n / 3, x, y + 2 * n / 3);

        divide(n / 3, x + n / 3, y);
        divide(n / 3, x + n / 3, y + n / 3);
        divide(n / 3, x + n / 3, y + 2 * n / 3);

        divide(n / 3, x + 2 * n / 3, y);
        divide(n / 3, x + 2 * n / 3, y + n / 3);
        divide(n / 3, x + 2 * n / 3, y + 2 * n / 3);
    }
}