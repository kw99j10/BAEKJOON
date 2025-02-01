import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21938 영상처리
public class Main {
    static int n, m, t, cnt;
    static int[][][] pixel;
    static int[][] grid;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pixel = new int[n][m][3]; //nxm, r,g,b
        // r+g+b 평균값 >= 경계값 t 일 때  255 , 작으면 0
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                pixel[i][j][0] = Integer.parseInt(st.nextToken());
                pixel[i][j][1] = Integer.parseInt(st.nextToken());
                pixel[i][j][2] = Integer.parseInt(st.nextToken());
            }
        }

        t = Integer.parseInt(br.readLine());
        grid = new int[n][m]; // 새로 저장할 화면
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((pixel[i][j][0] + pixel[i][j][1] + pixel[i][j][2]) / 3 >= t) {
                    grid[i][j] = 255;
                }
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] > 0) {
                    dfs(i, j); // 인접하면 같은 물체로 인식
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || grid[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
            visit[nx][ny] = true;
        }
    }
}