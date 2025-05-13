import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14712 넴모넴모
public class Main {
    static int n, m, count;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];
        dfs(1, 1);
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        if (x == n + 1) {
            count++;
            return;
        }

        if (y == m + 1) {
            dfs(x + 1, 1);
            return;
        }

        dfs(x, y + 1);

        if (grid[x - 1][y] == 1 && grid[x][y - 1] == 1 && grid[x - 1][y - 1] == 1) {
            return;
        }

        grid[x][y] = 1; // 2x2 사각형이 생기지 않는 경우
        dfs(x, y + 1);
        grid[x][y] = 0;
    }
}
