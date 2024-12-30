import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 6186 Best Grass
public class Main {
    static int n, m;
    static char[][] grass;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grass = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grass[i][j] = s.charAt(j);
            }
        }
        visit = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grass[i][j] == '#' && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visit[i][j] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || grass[nx][ny] == '.') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
