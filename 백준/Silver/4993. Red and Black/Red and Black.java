import java.io.*;
import java.util.*;

// 4993
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] grid;
    static int n, m, sx, sy, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = s.charAt(j);

                    if (grid[i][j] == '@') {
                        sx = i;
                        sy = j;
                    }
                }
            }
            sb.append(bfs(sx, sy)).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int i,int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        boolean[][] visit = new boolean[m][n];
        visit[i][j] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == '#') {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }
}