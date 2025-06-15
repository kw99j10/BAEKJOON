import java.io.*;
import java.util.*;

// 6146 신아를 만나러
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] grid;
    static int x, y, n, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) + 500;
        y = Integer.parseInt(st.nextToken()) + 500;
        n = Integer.parseInt(st.nextToken());

        grid = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 500;
            int b = Integer.parseInt(st.nextToken()) + 500;
            grid[a][b] = 1;
        }
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{500, 500, 0});
        boolean[][] visit = new boolean[1001][1001];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];

            if (cx == x && cy == y) {
                min = Math.min(min, distance);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= 1001 || ny < 0 || ny >= 1001 || visit[nx][ny] || grid[nx][ny] == 1) {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, distance + 1});
            }
        }
    }
}