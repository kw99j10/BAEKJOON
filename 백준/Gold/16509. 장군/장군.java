import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16509 장군
public class Main {
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //동->남->서->북
    static int[][] sang = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    static int[][] grid = new int[10][9];
    static int r1, c1, r2, c2, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        //처음 상, 왕 좌표 표시
        grid[r1][c1] = 1;
        grid[r2][c2] = 1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r1, c1, 0});
        grid[r1][c1] = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == r2 && y == c2) {
                answer = count;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 9 || grid[nx][ny] == 1) {
                    continue;
                }

                for (int k = 0; k < 2; k++) {
                    int dir = (d + k) % 4;
                    int nnx = nx + sang[dir][0];
                    int nny = ny + sang[dir][1];

                    if (nnx < 0 || nnx >= 10 || nny < 0 || nny >= 9 || grid[nnx][nny] == 1) {
                        continue;
                    }

                    nnx += sang[dir][0];
                    nny += sang[dir][1];

                    if (nnx < 0 || nnx >= 10 || nny < 0 || nny >= 9 || grid[nnx][nny] == -1) {
                        continue;
                    }

                    queue.add(new int[]{nnx, nny, count + 1});
                    grid[nnx][nny] = -1;
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}