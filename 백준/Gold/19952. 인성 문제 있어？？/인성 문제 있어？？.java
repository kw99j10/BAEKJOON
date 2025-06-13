import java.io.*;
import java.util.*;

// 19952 인성 문제 있어??
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int w, h, o, f, sx, sy, ex, ey;
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            o = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken()); // 힘
            sx = Integer.parseInt(st.nextToken()) - 1;
            sy = Integer.parseInt(st.nextToken()) - 1;
            ex = Integer.parseInt(st.nextToken()) - 1;
            ey = Integer.parseInt(st.nextToken()) - 1;

            maze = new int[h][w];
            for (int i = 0; i < o; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int l = Integer.parseInt(st.nextToken());
                maze[x][y] = l; // 장애물의 높이
            }
            sb.append(bfs(sx, sy) ? "잘했어!!" : "인성 문제있어??").append("\n");
        }
        System.out.print(sb);
    }

    static boolean bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[h][w];
        queue.add(new int[]{i, j, maze[i][j], f});
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentL = current[2];
            int power = current[3];

            if (x == ex && y == ey && power >= 0) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny]) {
                    continue;
                }

                int move = currentL - maze[nx][ny];

                // 현재 위치 >= 이동할 위치
                if (move >= 0) {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny, maze[nx][ny], power - 1});
                }

                // 이동할 위치 > 현재 위치 => 점프해야 하는 경우
                else {
                    if (power >= maze[nx][ny] - currentL) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny, maze[nx][ny], power - 1});
                    }
                }
            }
        }
        return false;
    }
}