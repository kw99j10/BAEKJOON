import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//미세먼지 안녕!
public class Main {
    static int r, c, t, gx1, gx2;
    static int[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        grid = new int[r][c];

        boolean isOne = true;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (isOne && grid[i][j] == -1) {
                    gx1 = i;
                    isOne = false;
                }
                if (!isOne && grid[i][j] == -1) {
                    gx2 = i;
                }
            }
        }

        while (t != 0) {
            //1. 미세먼지 확산
            spreadDust();

            //2. 공기청정기 작동
            //위 공기청정기: 공기청정기가 있는 행, 열, 첫 행, 첫 열
            operateUp();

            //아래 공기청정기: 공기청정기가 있는 행, 열, 마지막 행, 마지막 열
            operateDown();
            t--;
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                sum += grid[i][j];
            }
        }
        System.out.println(sum);
    }
    private static void spreadDust() {
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > 0) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx >= r || ny < 0 || ny >= c || grid[nx][ny] == -1) {
                            continue;
                        }
                        tmp[nx][ny] += grid[i][j] / 5;
                        count++;
                    }
                    tmp[i][j] -= grid[i][j] / 5 * count;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] += tmp[i][j];
            }
        }
    }
    private static void operateUp() {

        //하
        for (int i = gx1 - 1; i > 0; i--) {
            grid[i][0] = grid[i - 1][0];
        }

        //좌
        for (int j = 0; j < c - 1; j++) {
            grid[0][j] = grid[0][j + 1];
        }

        //상
        for (int i = 0; i < gx1; i++) {
            grid[i][c - 1] = grid[i + 1][c - 1];
        }

        //우
        for (int j = c - 1; j > 1; j--) {
            grid[gx1][j] = grid[gx1][j - 1];
        }
        grid[gx1][1] = 0;
    }
    private static void operateDown() {

        //상
        for (int i = gx2 + 1; i < r - 1; i++) {
            grid[i][0] = grid[i + 1][0];
        }

        //좌
        for (int j = 0; j < c - 1; j++) {
            grid[r - 1][j] = grid[r - 1][j + 1];
        }


        //하
        for (int i = r - 1; i > gx2; i--) {
            grid[i][c - 1] = grid[i - 1][c - 1];
        }

        //우
        for (int j = c - 1; j > 1; j--) {
            grid[gx2][j] = grid[gx2][j - 1];
        }
        grid[gx2][1] = 0;
    }
}
