import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 2178 미로 탐색
public class Main {
    static int n, m;
    static int[][] maze;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        boolean[][] visit = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if (cx == n - 1 && cy == m - 1) {
                System.out.println(current[2]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || maze[nx][ny] == 0) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, current[2] + 1});
            }
        }
    }
}
