import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count;
    static int[][] cheese;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    count++; //치즈 개수
                }
            }
        }

        int time = 0;
        while (count != 0) {
            time++;
            bfs();
        }
        System.out.println(time);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int[][] air = new int[n][m]; //접촉 면

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (cheese[nx][ny] == 1) {
                    air[nx][ny] += 1; //현재 치즈가 맞닿은 접촉 면의 개수)
                } else if (cheese[nx][ny] == 0 && air[nx][ny] == 0) {
                    air[nx][ny] = -1; //외부 공기 표시(빈 공간)
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (air[i][j] >= 2) {
                    cheese[i][j] = 0;
                    count--; //맞닿은 면이 2개 이상일 때, 치즈를 녹임
                }
            }
        }
    }
}
