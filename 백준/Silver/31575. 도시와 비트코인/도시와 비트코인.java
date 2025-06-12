import java.io.*;
import java.util.*;

// 31575 도시와 비트코인
class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int n, m;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[m][n];
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            if (x == m - 1 && y == n - 1) {
                System.out.println("Yes");
                return;
            }
            for (int d = 0; d < 2; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny] && grid[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println("No");
    }
}