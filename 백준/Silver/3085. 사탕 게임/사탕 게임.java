import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3085 사탕 게임
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] grid;
    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                change(i, j, grid[i][j]); //사탕 개수 완탐
            }
        }
        System.out.println(max);
    }

    static void change(int x, int y, char color) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == color) {
                continue;
            }

            // 사탕의 색이 다른 인접한 두 칸을 교환
            grid[x][y] = grid[nx][ny];
            grid[nx][ny] = color;

            countMax();

            // 교환한 부분 복구
            grid[nx][ny] = grid[x][y];
            grid[x][y] = color;
        }
    }

    private static void countMax() {

        for (int i = 0; i < n; i++) {

            int rowMax = 1;
            int colMax = 1;

            for (int j = 1; j < n; j++) {
                if (grid[i][j] == grid[i][j - 1]) {
                    rowMax++;
                }else {
                    max = Math.max(max, rowMax);
                    rowMax = 1;
                }

                if (grid[j][i] == grid[j - 1][i]) {
                    colMax++;
                }else{
                    max = Math.max(max, colMax);
                    colMax = 1;
                }
            }
            max = Math.max(max, Math.max(rowMax, colMax));
        }
    }
}