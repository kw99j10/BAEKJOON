import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7562: 나이트의 이동
class Main {

    static int l, sx, sy, gx, gy, count;
    static int[][] chess;
    static int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
    static int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());

            chess = new int[l][l];
            count = 0;
            bfs(sx, sy);
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        boolean[][] visit = new boolean[l][l];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[x][y] = true;
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cnt = current[2];

            if (cx == gx && cy == gy) {
                count = cnt;
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, cnt + 1});
            }
        }
    }
}