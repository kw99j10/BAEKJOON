import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10157 자리배정
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        if (k > c * r) {
            System.out.println(0);
            return;
        }

        int dir = 0;
        int x = r - 1, y = 0;
        int[][] grid = new int[r][c];
        for (int i = 1; i <= r * c; i++) {
            grid[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || grid[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == k) {
                    System.out.println((j + 1) + " " + (r - i));
                    return;
                }
            }
        }
    }
}