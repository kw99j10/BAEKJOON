import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14391 종이 조각
public class Main {
    static int n, m, max;
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        backtracking(0, 0); //(0,0)부터 자르기 시작
        System.out.println(max);
    }

    static void backtracking(int x, int y) {
        // visit: x축, !visit: y축

        if (x == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int sum1 = 0;
                for (int j = 0; j < m; j++) {
                    if (visit[i][j]) {
                        sum1 = sum1 * 10 + arr[i][j];
                    } else {
                        sum += sum1;
                        sum1 = 0;
                    }
                }
                sum += sum1;
            }

            for (int j = 0; j < m; j++) {
                int sum2 = 0;
                for (int i = 0; i < n; i++) {
                    if (!visit[i][j]) {
                        sum2 = sum2 * 10 + arr[i][j];
                    } else {
                        sum += sum2;
                        sum2 = 0;
                    }
                }
                sum += sum2;
            }
            max = Math.max(max, sum);
            return;
        }

        if (y == m) {
            backtracking(x + 1, 0);
            return;
        }

        visit[x][y] = true;
        backtracking(x, y + 1);
        visit[x][y] = false;
        backtracking(x, y + 1);
    }
}