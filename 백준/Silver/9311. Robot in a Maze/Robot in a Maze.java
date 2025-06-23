import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 9311 Robot in a Maze
class Main {
    static int r, c, sx, sy, min;
    static char[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            maze = new char[r][c];

            sx = 0;
            sy = 0;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < r; j++) {
                String s = br.readLine();
                for (int k = 0; k < c; k++) {
                    maze[j][k] = s.charAt(k);

                    if (maze[j][k] == 'S') {
                        sx = j;
                        sy = k;
                    }
                }
            }
            bfs(sx, sy);
            sb.append(min == Integer.MAX_VALUE ? "No Exit" : "Shortest Path: " + min).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[r][c];
        visit[i][j] = true;
        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (maze[x][y] == 'G') {
                min = Math.min(min, dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || maze[nx][ny] == 'X') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

    }
}