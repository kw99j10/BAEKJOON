import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14391 종이 조각
public class Main {
    static int n, m, max;
    static int[][] paper;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                paper[i][j] = s.charAt(j) - '0';
            }
        }

        visit = new boolean[n][m];
        comb(0, 0);
        System.out.println(max);
    }

    static void comb(int x, int y) {
        if (x == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int tmp1 = 0; // 가로합
                for (int j = 0; j < m; j++) {
                    if (visit[i][j]) {
                        tmp1 = tmp1 * 10 + paper[i][j];
                    } else {
                        sum += tmp1;
                        tmp1 = 0;
                    }
                }
                sum += tmp1;
            }

            for (int j = 0; j < m; j++) {
                int tmp2 = 0; // 세로합
                for (int i = 0; i < n; i++) {
                    if (!visit[i][j]) {
                        tmp2 = tmp2 * 10 + paper[i][j];
                    } else{
                        sum += tmp2;
                        tmp2 = 0;
                    }
                }
                sum += tmp2;
            }
            max = Math.max(max, sum);
            return;
        }

        int nx = (y == m - 1) ? x + 1 : x;
        int ny = (y == m - 1) ? 0 : y + 1;

        visit[x][y] = true;
        comb(nx, ny); // 가로
        visit[x][y] = false;
        comb(nx, ny); // 세로
    }
}