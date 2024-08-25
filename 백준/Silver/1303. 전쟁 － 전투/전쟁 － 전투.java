import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1303 전쟁 - 전투
public class Main {
    static int n, m;
    static char[][] war;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static long white, blue, tmpWhite, tmpBlue; //white: 우리 병사, blue: 적국

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        war = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                war[i][j] = s.charAt(j);
            }
        }
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmpWhite = 0;
                tmpBlue = 0;
                if (!visit[i][j]) {
                    if (war[i][j] == 'W') {
                        dfs(i, j);
                        white += (long) Math.pow(tmpWhite, 2);
                    } else {
                        dfs(i, j);
                        blue += (long) Math.pow(tmpBlue, 2);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    if (war[i][j] == 'B') {
                        blue++;
                    }else{
                        white++;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    static void dfs(int x, int y) {
        char tmp = war[x][y];
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] || war[nx][ny] != tmp) {
                continue;
            }

            if (tmp == 'W') {
                tmpWhite++;
            } else {
                tmpBlue++;
            }
            visit[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}