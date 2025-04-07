import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2234 성곽
public class Main {
    static int n, m, num;
    static int[][] grid;
    static boolean[][] visit;
    static int[][] wall;
    static ArrayList<Integer> size = new ArrayList<>(); // 각 방의 크기
    static int[][] move = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 서,북,동,남

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = 1;
        wall = new int[m][n]; // 벽번호
        visit = new boolean[m][n];
        int count = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                    num++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
        System.out.println(getdMax());
    }

    static int getdMax() {
        int dMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cWall = wall[i][j];
                for (int d = 0; d < 4; d++) {
                    int nx = i + move[d][0];
                    int ny = j + move[d][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    int nWall = wall[nx][ny];
                    if (cWall != nWall) {
                        dMax = Math.max(dMax, size.get(cWall - 1) + size.get(nWall - 1));
                    }
                }
            }
        }
        return dMax;
    }

    static int bfs(int i, int j) {
        visit[i][j] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        wall[i][j] = num;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny]) {
                    continue;
                }

                // 벽이 없는 곳
                if ((grid[x][y] & (1 << d)) == 0) {
                    visit[nx][ny] = true;
                    wall[nx][ny] = num;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        size.add(cnt);
        return cnt;
    }
}