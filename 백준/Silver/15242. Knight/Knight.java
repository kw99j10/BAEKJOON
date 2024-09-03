import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 15242 Knight
public class Main {
    static int sx, sy, ex, ey;
    static String[][] grid = new String[8][8];
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        if (a.equals(b)) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[j][i] = String.valueOf((char) ('a' + i)) + (j + 1);
                if (grid[j][i].equals(a)) {
                    sx = i;
                    sy = j;
                }
                if (grid[j][i].equals(b)) {
                    ex = i;
                    ey = j;
                }
            }
        }
        bfs(sx, sy);
    }

    static void bfs(int kx, int ky) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[8][8];
        queue.add(new int[]{kx, ky, 0});
        visit[kx][ky] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            if (x == ex && y == ey) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || visit[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
            }
        }
    }
}