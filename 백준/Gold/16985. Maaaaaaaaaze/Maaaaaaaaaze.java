import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16985 Maaaaaaaaaze
public class Main {
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[][][] grid;
    static int[][][] tmp;
    static int min = Integer.MAX_VALUE;
    static int[] selected;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        grid = new int[5][5][5];
        tmp = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        selected = new int[5]; // 미로 방향 경우의 수
        isSelected = new boolean[5]; // 쌓는 경우의 수
        perm(0); // 1. 5x5 판을 자유롭게 회전 4x4x4x4x4 => 1024
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void perm(int idx) {
        if (idx == 5) {
            stack(0); // 2. 판을 5개 쌓는 순서 => 5! => 120
            return;
        }

        for (int d = 0; d < 4; d++) {
            selected[idx] = d; // 미로 방향
            perm(idx + 1);
        }
    }

    static void stack(int idx) {
        if (idx == 5) {
            bfs(); // 3. 미로 탈출 최솟값 갱신
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;

                int[][] r = turn(grid[i], selected[idx]);
                copyArray(idx, r);

                stack(idx + 1);
                isSelected[i] = false;
            }
        }
    }

    static void bfs() {

        if (tmp[0][0][0] == 0 || tmp[4][4][4] == 0) {
            return; // 시작 및 도착 불가
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[5][5][5];

        queue.add(new int[]{0, 0, 0, 0});
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];
            int count = current[3];

            if (x == 4 && y == 4 && z == 4) {
                min = Math.min(min, count);
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                // 0이 아닌 곳만
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || visit[nx][ny][nz] || tmp[nx][ny][nz] == 0) {
                    continue;
                }
                visit[nx][ny][nz] = true;
                queue.add(new int[]{nx, ny, nz, count + 1});
            }
        }
    }

    static int[][] turn(int[][] arr, int count) {
        for (int c = 0; c < count; c++) {
            int[][] tmp = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    tmp[j][5 - i - 1] = arr[i][j];
                }
            }
            arr = tmp;
        }
        return arr;
    }

    static void copyArray(int idx, int[][] r) {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                tmp[idx][j][k] = r[j][k];
            }
        }
    }
}