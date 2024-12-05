import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17484 진우의 달 여행
public class Main {
    static int n, m, min = Integer.MAX_VALUE;
    static int[][] grid;
    static int[] dir = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0번 행부터
        for (int i = 0; i < m; i++) {
            dfs(0, i, -1, 0); //x좌표,y좌표,방향(초기 쓰레기값),최소값
        }
        System.out.println(min);
    }

    static void dfs(int x, int y, int d, int sum) {

        if (x == n) {
            min = Math.min(min, sum);
            return;
        }

        for (int k = 0; k < 3; k++) {
            if (k == d) {
                continue;
            }
            int ny = y + dir[k];
            if (ny < 0 || ny >= m) {
                continue;
            }

            dfs(x + 1, ny, k, sum + grid[x][y]);
        }
    }
}
