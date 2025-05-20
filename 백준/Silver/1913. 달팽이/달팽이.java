import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1913 달팽이
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int count = n * n;

        int dir = 0;
        int sx = 0, sy = 0;
        arr[sx][sy] = count;
        while (count != 1) {

            int nx = sx + dx[dir];
            int ny = sy + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                continue;
            }

            arr[nx][ny] = --count;
            sx = nx;
            sy = ny;
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == num) {
                    x = (i + 1);
                    y = (j + 1);
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(x + " " + y);
    }
}