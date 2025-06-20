import java.io.*;
import java.util.*;

// 6189
class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] grid;
    static boolean[][] visit;
    static int n, m, k, sx, sy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);

                if (grid[i][j] == 'B') {
                    sx = i;
                    sy = j;
                }
            }
        }
        bfs(sx, sy);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[i][j] = true;
        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (grid[x][y] == 'C') {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || grid[nx][ny] == '*') {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }
    }
}