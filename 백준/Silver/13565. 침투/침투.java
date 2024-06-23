import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 13565 침투
public class Main {
    static int m, n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        int cntOut = 0;
        int cntIn = 0;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                cntOut++;
            }
            if (grid[m - 1][i] == 0) {
                cntIn++;
            }
        }

        // outer side 혹은 inner side 에 흰색이 0개인 경우
        if (cntOut == 0 || cntIn == 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                if (bfs(i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    static boolean bfs(int i) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[m][n];

        visit[0][i] = true;
        queue.add(new int[]{0, i});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == m - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 1 || visit[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
        return false;
    }
}