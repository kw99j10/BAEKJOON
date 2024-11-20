import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1331 나이트 투어
public class Main {
    static int[][] move = {{2, 1}, {1, 2}, {-2, -1}, {-1, -2}, {2, -1}, {-2, 1}, {1, -2}, {-1, 2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[6][6];

        String s = br.readLine();
        int x = s.charAt(0) - 'A';
        int y = s.charAt(1) - '1';
        grid[x][y] = 1;

        int tmpX = x;
        int tmpY = y;
        int count = 1;
        boolean isCan = true;

        while (true) {
            if (count == 36) {
                break;
            }

            s = br.readLine();
            int x2 = s.charAt(0) - 'A';
            int y2 = s.charAt(1) - '1';
            boolean isPossible = false;

            for (int d = 0; d < 8; d++) {
                int nx = tmpX + move[d][0];
                int ny = tmpY + move[d][1];

                if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || grid[nx][ny] == 1) {
                    continue;
                }

                if (x2 == nx && y2 == ny) {
                    isPossible = true;
                    grid[nx][ny] = 1;
                    break;
                }
            }

            if (!isPossible) {
                isCan = false;
                break;
            }
            count++;
            tmpX = x2;
            tmpY = y2;
        }

        boolean isStart = false;
        if (isCan) {
            for (int d = 0; d < 8; d++) {
                int nx = tmpX + move[d][0];
                int ny = tmpY + move[d][1];
                if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6) {
                    continue;
                }
                if (nx == x && ny == y) {
                    isStart = true;
                    break;
                }
            }
        }
        if (isCan && isStart) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}