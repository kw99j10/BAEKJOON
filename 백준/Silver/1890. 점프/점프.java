import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1890 점프
public class Main {
    static int n;
    static int[][] map;
    static long[][] dp;
    static int[][] dir = {{0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 0)); //(0,0)부터 시작
    }
    static long dfs(int i, int j) {
        if (i == n - 1 && j == n - 1) {
            return 1; //(n-1,n-1)에 오면 종료
        }

        if (dp[i][j] != -1) {
            return dp[i][j]; //방문한 칸이면 종료
        }

        dp[i][j] = 0;       
        for (int d = 0; d < 2; d++) {
            int nx = i + dir[d][0] * map[i][j];
            int ny = j + dir[d][1] * map[i][j];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            dp[i][j] += dfs(nx, ny);
        }
        return dp[i][j];
    }
}