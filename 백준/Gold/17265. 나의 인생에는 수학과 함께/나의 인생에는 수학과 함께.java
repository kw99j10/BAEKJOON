import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 17265 나의 인생에는 수학과 함께
public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static char[][] grid;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine().replace(" ", "");
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        dfs(0, 0, grid[0][0] - '0');
        System.out.println(max + " " + min);
    }

    static void dfs(int x, int y, int sum) {

        if (x == n - 1 && y == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            //숫자인 경우
            if (Character.isDigit(grid[nx][ny])) {
                if (grid[x][y] == '+') {
                    dfs(nx, ny, sum + (grid[nx][ny] - '0'));
                } else if (grid[x][y] == '-') {
                    dfs(nx, ny, sum - (grid[nx][ny] - '0'));
                } else if (grid[x][y] == '*') {
                    dfs(nx, ny, sum * (grid[nx][ny] - '0'));
                }
            }else{
                dfs(nx, ny, sum); //연산자인 경우
            }
        }
    }
}