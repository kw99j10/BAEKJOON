import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16173 점프왕 쩰리 (Small)
public class Main {
    static int n;
    static int[][] grid;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "HaruHaru" : "Hing");
    }

    static boolean bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new int[]{0, 0, grid[0][0]});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int score = current[2];

            if (grid[x][y] == -1) {
                return true;
            }

            for (int d = 0; d < 2; d++) {
                int nx = x;
                int ny = y;

                nx += dx[d] * score;
                ny += dy[d] * score;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, grid[nx][ny]});
            }
        }
        return false;
    }
}