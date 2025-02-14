import java.io.*;
import java.util.StringTokenizer;

// 18290 NM과 K
public class Main {
    static int n, m, k, max = Integer.MIN_VALUE;
    static int[][] grid;
    static boolean[][] visit;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        comb(0, 0);
        System.out.println(max);
    }

    static void comb(int cnt, int sum) {
        if (cnt == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && isPossible(i, j)) {
                    visit[i][j] = true;
                    comb(cnt + 1, sum + grid[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && visit[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}