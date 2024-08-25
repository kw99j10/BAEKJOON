import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 17086 아기 상어 2
public class Main {
    static int n, m, max;
    static int[][] space;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static ArrayList<int[]> lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        space = new int[n][m];
        lists = new ArrayList<>(); // 아기 상어가 있는 좌표
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 1) {
                    lists.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (space[i][j] == 1) {
                    space[i][j] = 0; //아기 상어가 있는 좌표
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, space[i][j]);
            }
        }
        System.out.println(max);
    }
    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        for (int[] list : lists) {
            queue.add(new int[]{list[0], list[1], 0});
            visit[list[0]][list[1]] = true;
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
                space[nx][ny] = Math.max(space[x][y], cnt + 1);
            }
        }
    }
}