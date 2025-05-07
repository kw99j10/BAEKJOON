import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18126 너구리 구구
public class Main {
    static int n;
    static int[][] grid;
    static boolean[] visit;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[a][b] = c;
            grid[b][a] = c;
        }
        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(1, 0);
        System.out.println(max);
    }

    static void dfs(int start, long radius) {
        for (int i = 1; i <= n; i++) {
            if (grid[start][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(i, radius + grid[start][i]);
            }
            max = Math.max(max, radius);
        }
    }
}