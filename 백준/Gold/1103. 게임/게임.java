import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1103 게임
public class Main {
    static int n, m, max;
    static boolean isInfinite;
    static char[][] board;
    static boolean[][] visit;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visit = new boolean[n][m];
        dp = new int[n][m];

        visit[0][0] = true; // (0,0) 에서 최소 1번은 던짐
        dfs(0, 0, board[0][0] - '0', 1);
        System.out.println(isInfinite ? -1 : max);
    }

    static void dfs(int x, int y, int move, int cnt) {

        dp[x][y] = cnt;
        max = Math.max(max, dp[x][y]);
        for (int d = 0; d < 4; d++) {
            int nx = x + move * dx[d];
            int ny = y + move * dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 'H' || dp[nx][ny] > cnt) {
                continue;
            }

            if (visit[nx][ny]) {
                isInfinite = true; // 동전 무한 반복
                return;
            }

            visit[nx][ny] = true;
            dfs(nx, ny, board[nx][ny] - '0', cnt + 1);
            visit[nx][ny] = false;
        }
    }
}