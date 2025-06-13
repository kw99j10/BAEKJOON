import java.io.*;
import java.util.*;

// 28471 W키가 빠진 성원이
class Main {
    static int[][] move = {{-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 0}};
    static int n, ex, ey;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);

                if (grid[i][j] == 'F') {
                    ex = i;
                    ey = j;
                }
            }
        }

        bfs(ex, ey);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];
        visit[i][j] = true;
        queue.add(new int[]{i, j});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 7; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == '#') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        System.out.println(count);
    }
}