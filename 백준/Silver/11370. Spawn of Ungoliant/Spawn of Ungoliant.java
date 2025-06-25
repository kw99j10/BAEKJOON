import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 11370
class Main {
    static int r, c, sx, sy;
    static char[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (r == 0 && c == 0) {
                break;
            }
            maze = new char[c][r];

            sx = 0;
            sy = 0;
            for (int j = 0; j < c; j++) {
                String s = br.readLine();
                for (int k = 0; k < r; k++) {
                    maze[j][k] = s.charAt(k);

                    if (maze[j][k] == 'S') {
                        sx = j;
                        sy = k;
                    }
                }
            }
            bfs(sx, sy);

            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    sb.append(maze[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[c][r];
        visit[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= c || ny < 0 || ny >= r || visit[nx][ny] || maze[nx][ny] == '.') {
                    continue;
                }
                visit[nx][ny] = true;
                maze[nx][ny] = 'S';
                queue.add(new int[]{nx, ny});
            }
        }

    }
}