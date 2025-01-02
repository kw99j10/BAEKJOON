import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7576 토마토
public class Main {
    static int n, m, count;
    static int[][] tomato;
    static ArrayDeque<int[]> queue;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tomato = new int[m][n];
        queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 0) {
                    count++;
                } else if (tomato[i][j] == 1) {
                    tomato[i][j] = 0; // 익은 토마토 표시
                    queue.add(new int[]{i, j, tomato[i][j]}); // 익은 토마토를 담음
                }
            }
        }

        if (count == 0) {
            System.out.println(0); // 익을 토마토가 없음
            return;
        }

        visit = new boolean[m][n];
        bfs();

        int min = 0;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && tomato[i][j] == 0) {
                    cnt++; // 안 익은 토마토가 있음
                }
                min = Math.max(min, tomato[i][j]);
            }
        }
        System.out.println(cnt == 0 ? min : -1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int days = current[2];

            visit[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] || tomato[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                tomato[nx][ny] = days + 1;
                queue.add(new int[]{nx, ny, days + 1});
            }
        }
    }
}
