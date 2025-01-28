import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18808 스티커 붙이기
public class Main {
    static int n, m, k, r, c;
    static int[][] grid; // 노트북
    static int[][] paper; // 모눈종이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        // 스티커의 개수만큼
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine()); // 모눈종이 행, 열
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            paper = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    paper[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            simulation();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void simulation() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n * m; j++) {
                int x = j / m;
                int y = j % m;
                if (x + r > n || y + c > m) {
                    continue; // 노트북 범위 밖
                }

                if (check(x, y)) {
                    return; // 붙일 수 있는지
                }
            }
            rotate(); // 붙일 곳이 없음
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[x + i][y + j] == 1 && paper[i][j] == 1) {
                    return false; // 이미 붙어있음
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    grid[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    // 모눈종이 회전하기
    static void rotate() {
        int nr = c;
        int nc = r;
        int[][] tmp = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                tmp[i][j] = paper[r - j - 1][i];
            }
        }

        r = nr;
        c = nc;
        paper = tmp;
    }
}