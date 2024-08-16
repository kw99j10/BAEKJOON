import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5958 Space Exploration
public class Main {
    static int n;
    static char[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
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
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == '.') {
                continue;
            }
            dfs(nx, ny);
        }
    }
}