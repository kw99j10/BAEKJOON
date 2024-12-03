import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 16234 인구 이동
public class Main {
    static int n, l, r, days;
    static int[][] grid;
    static boolean[][] visit;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(days);
    }

    static void move() {
        while (true) {
            visit = new boolean[n][n];
            boolean isPossible = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && bfs(i, j)) {
                        isPossible = true;
                    }
                }
            }
            if (!isPossible) {
                break;
            }
            days++;
        }
    }

    static boolean bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> union = new ArrayList<>(); // 연합 리스트

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current[0] + move[d][0];
                int ny = current[1] + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                    continue;
                }

                if (Math.abs(grid[nx][ny] - grid[current[0]][current[1]]) >= l &&
                        Math.abs(grid[nx][ny] - grid[current[0]][current[1]]) <= r) {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                }
            }
        }

        // 연합이 있다 -> 인구 이동이 가능하다
        if (union.size() > 1) {
            int sum = 0; // 연합의 인구 수
            for (int[] current : union) {
                sum += grid[current[0]][current[1]];
            }

            for (int[] current : union) {
                grid[current[0]][current[1]] = sum / union.size();
            }
            return true;
        } else {
            return false;
        }
    }
}