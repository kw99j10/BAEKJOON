import java.io.*;
import java.util.*;

// 25416 빠른 숫자 탐색
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] grid;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        grid = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bfs(r, c);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 0});
        boolean[][] visit = new boolean[5][5];
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int count = current[2];

            if (grid[cx][cy] == 1) {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visit[nx][ny] || grid[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }
        System.out.println(-1);
    }
}