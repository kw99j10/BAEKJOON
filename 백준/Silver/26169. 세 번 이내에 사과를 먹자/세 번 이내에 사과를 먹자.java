import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 26169 세 번 이내에 사과를 먹자
public class Main {
    static int max;
    static int[][] grid;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        grid = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dfs(x, y, 0, 0);
        System.out.println(max >= 2 ? 1 : 0);
    }

    static void dfs(int x, int y, int cnt, int sum) {

        if (sum >= 2 && cnt <= 3) {
            max = Math.max(max, sum);
            return;
        }

        int tmp = grid[x][y];
        grid[x][y] = -1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || grid[nx][ny] == -1) {
                continue;
            }
            dfs(nx, ny, cnt + 1, sum + grid[nx][ny]);
        }
        grid[x][y] = tmp;
    }
}