import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20057 마법사 상어와 토네이도
public class Main {
    static int[][] grid;
    static int n, sx, sy, sd, sum;
    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //좌,하,우,상
    static int[][][] move = {
            {{-2, 0}, {2, 0}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}, {0, -2}},
            {{0, -2}, {0, 2}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {2, 0}},
            {{-2, 0}, {2, 0}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}, {0, 2}},
            {{0, 2}, {0, -2}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}, {-2, 0}}
    }; // 2%, 7%, 1%, 10%, 5%
    static double[] ratio = {0.02, 0.02, 0.07, 0.07, 0.01, 0.01, 0.1, 0.1, 0.05};

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

        // 토네이도 시작점
        sx = n / 2;
        sy = n / 2;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < i; k++) {
                    tornado(); //i번째 토네이도에서 2번 k만큼 이동
                }
                sd = (sd + 1) % 4; // 이동이 끝나면 방향 전환
            }
        }

        // 마지막에 한번 더 이동
        for (int i = 0; i < n - 1; i++) {
            tornado();
        }
        System.out.println(sum);
    }

    static void tornado() {
        int nx = sx + dir[sd][0];
        int ny = sy + dir[sd][1]; // y의 위치

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            return;
        }

        int a = grid[nx][ny]; //(x->y 이동시의 y 모래)
        grid[nx][ny] = 0;
        int sandSum = 0; // 이동한 모래양

        //9방향 모래 이동
        for (int i = 0; i < 9; i++) {
            int nnx = nx + move[sd][i][0];
            int nny = ny + move[sd][i][1];

            if (nnx < 0 || nnx >= n || nny < 0 || nny >= n) {
                sum += (int) (a * ratio[i]);
            } else {
                grid[nnx][nny] += (int) (a * ratio[i]); // 모래 누적
            }
            sandSum += (int) (a * ratio[i]);
        }

        int nnx = nx + dir[sd][0];
        int nny = ny + dir[sd][1]; // a의 위치

        if (nnx < 0 || nnx >= n || nny < 0 || nny >= n) {
            sum += (a - sandSum);
        } else {
            grid[nnx][nny] += (a - sandSum);
        }

        sx = nx;
        sy = ny;
    }
}