import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 22352 항체 인식
public class Main {
    static int n, m, cnt;
    static int[][] result;
    static int[][] ready;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ready = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ready[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ready[i][j] != result[i][j]) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        System.out.println("YES");
    }

    static void check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ready[i][j] != result[i][j]) {
                    bfs(i, j, ready[i][j], result[i][j]); // 기존 -> 변형
                    return;
                }
            }
        }
    }

    static void bfs(int i, int j, int origin, int news) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        queue.add(new int[]{i, j});
        visit[i][j] = true;

        ready[i][j] = news; // 백신 주입

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }

                if (ready[nx][ny] == origin) {
                    visit[nx][ny] = true;
                    ready[nx][ny] = news;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}