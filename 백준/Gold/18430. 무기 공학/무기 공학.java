import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18430 무기 공학
public class Main {
    static int[][] move = {{0, -1, 1, 0}, {0, -1, -1, 0}, {0, 1, -1, 0}, {0, 1, 1, 0}};
    static int n, m, max;
    static int[][] grid;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == 1 || m == 1) {
            System.out.println(0); // 부메랑을 만들 수 없는 경우
            return;
        }

        visit = new boolean[n][m];
        dfs(0, 0, 0); // 0,0 부터 n-1,m-1 까지 완전 탐색
        System.out.println(max);
    }

    static void dfs(int x, int y, int sum) {
        if (x == n) {
            max = Math.max(max, sum);
            return;
        }

        if (y == m) {
            x++;
            y = 0;
            dfs(x, y, sum);
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + move[d][0]; int ny = y + move[d][1];
            int kx = x + move[d][2]; int ky = y + move[d][3];
            if (isPossible(nx, ny) && isPossible(kx, ky) && !visit[x][y]) {
                visit[x][y] = true;
                visit[nx][ny] = true;
                visit[kx][ky] = true;
                dfs(x, y + 1, sum + grid[x][y] * 2 + grid[nx][ny] + grid[kx][ky]);
                visit[x][y] = false;
                visit[nx][ny] = false;
                visit[kx][ky] = false;
            }
        }
        dfs(x, y + 1, sum); // 부메랑을 만들지 않는 경우
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && !visit[x][y];
    }
}