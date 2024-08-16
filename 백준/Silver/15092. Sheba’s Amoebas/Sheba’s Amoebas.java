import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5958 Space Exploration
public class Main {
    static int n, m;
    static char[][] grid;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int x, int y) {

        if (grid[x][y] == '.') {
            return;
        }

        grid[x][y] = '.';
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '.') {
                continue;
            }
            dfs(nx, ny);
        }
    }
}