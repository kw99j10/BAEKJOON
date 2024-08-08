import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14620 꽃길
public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] grid;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][n];
        bruteforce(0, 0); // 격자 완탐
        System.out.println(min);
    }

    //꽃이 필 수 있는지 여부 탐색
    static boolean search(int x, int y) {
        if (visit[x][y]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    static void bruteforce(int cost, int cnt) {
        if (cnt == 3) {
            min = Math.min(min, cost);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                if (search(i, j)) {
                    visit[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + move[d][0];
                        int ny = j + move[d][1];
                        visit[nx][ny] = true;
                        sum += grid[nx][ny];
                    }
                    bruteforce(cost + sum, cnt + 1);
                    visit[i][j] = false;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + move[d][0];
                        int ny = j + move[d][1];
                        visit[nx][ny] = false;
                    }
                }
            }
        }
    }
}