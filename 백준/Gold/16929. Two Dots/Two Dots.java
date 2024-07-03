import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16929 Two Dots
public class Main {
    static int n, m;
    static boolean isTrue;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        isTrue = false; //사이클 존재 여부
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                //사이클 여부 완탐(시작위치 좌표, 움직일 좌표, 색, 사이클 길이)
                visit = new boolean[n][m];
                dfs(i, j, i, j, map[i][j], 0);

                if (isTrue) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    static void dfs(int sx, int sy, int x, int y, char color, int cycle) {

        if (isTrue) {
            return;
        }

        visit[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != color) {
                continue;
            }

            if (visit[nx][ny] && cycle >= 3 && (sx != nx || sy != ny)) {
                isTrue = true;
            } else if (!visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(x, y, nx, ny, map[nx][ny], cycle + 1);
            }
        }
    }
}