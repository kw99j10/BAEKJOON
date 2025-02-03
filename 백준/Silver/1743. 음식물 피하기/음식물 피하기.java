import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1743 음식물 피하기
public class Main {
    static int n, m, k, count;
    static int[][] grid;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 1;
        }

        visit = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || grid[nx][ny] == 0) {
                continue;
            }

            visit[nx][ny] = true;
            dfs(nx, ny);
            count++;
        }
    }
}