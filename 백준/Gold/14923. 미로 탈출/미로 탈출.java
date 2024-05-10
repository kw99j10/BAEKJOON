import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m, hx, hy, ex, ey, answer;
    static int[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        st = new StringTokenizer(br.readLine());
        hx = Integer.parseInt(st.nextToken()) - 1;
        hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        bfs(hx, hy);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    static void bfs(int startX, int startY) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[n][m][2];
        queue.add(new int[]{startX, startY, 0, 0});
        visit[startX][startY][0] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            int wizard = current[3];

            if (x == ex && y == ey) {
                answer = Math.min(answer, count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||visit[nx][ny][wizard]) {
                    continue;
                }

                if (maze[nx][ny] == 1 && wizard == 0) {
                    visit[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, count + 1, 1});
                } else if (maze[nx][ny] == 0) {
                    visit[nx][ny][wizard] = true;
                    queue.add(new int[]{nx, ny, count + 1, wizard});
                }
            }
        }
    }
}