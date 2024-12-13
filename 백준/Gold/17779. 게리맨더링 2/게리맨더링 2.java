import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17779 게리맨더링 2
public class Main {
    static int n, total, min = Integer.MAX_VALUE;
    static int[][] grid;
    static boolean[][] border;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                total += grid[i][j];
            }
        }

        simulation();
        System.out.println(min);
    }

    static void simulation() {

        // 1. 기준점 (x,y)와 경계의 길이 d1,d2를 정함
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;
                        boundary(x, y, d1, d2); // 경계선 셋팅
                        election(x, y, d1, d2); // 선거구 나누기
                    }
                }
            }
        }
    }

    static void boundary(int x, int y, int d1, int d2) {
        border = new boolean[n][n];

        // 1,4 경계선
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        // 2,3 경계선
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }
    }

    static void election(int x, int y, int d1, int d2) {
        int[] sum = new int[5]; // 각 선거구 합

        one(x, y, d1, sum); // 1 선거구
        two(x, y, d2, sum); // 2 선거구
        three(x, y, d1, d2, sum); // 3 선거구
        four(x, y, d1, d2, sum); // 4 선거구

        sum[4] = total - (sum[0] + sum[1] + sum[2] + sum[3]);
        Arrays.sort(sum);
        min = Math.min(min, sum[4] - sum[0]);
    }

    static void one(int x, int y, int d1, int[] sum) {
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) {
                    break;
                }
                sum[0] += grid[i][j];
            }
        }
    }

    static void two(int x, int y, int d2, int[] sum) {
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) {
                    break;
                }
                sum[1] += grid[i][j];
            }
        }
    }

    static void three(int x, int y, int d1, int d2, int[] sum) {
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) {
                    break;
                }
                sum[2] += grid[i][j];
            }
        }
    }

    static void four(int x, int y, int d1, int d2, int[] sum) {
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                sum[3] += grid[i][j];
            }
        }
    }
}