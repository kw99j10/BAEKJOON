import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 2636 치즈
public class Main {
    static int r, c, count;
    static int[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new int[r][c];
        count = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int time = 0;
        int last = 0;
        while (count != 0) {
            last = count;
            time++;
            count = bfs();
        }
        System.out.println(time);
        System.out.println(last);
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[r][c];
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny]) {
                    continue;
                }

                // 공기가 있는 곳을 다시 넣음
                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                } else {
                    queue.offer(new int[]{nx, ny});
                }
                visit[nx][ny] = true;
            }
        }

        return checkCheese();
    }

    private static int checkCheese() {
        int cheese = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    cheese++;
                }
            }
        }
        return cheese;
    }
}