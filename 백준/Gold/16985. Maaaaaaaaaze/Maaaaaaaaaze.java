import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16985 Maaaaaaaaaze
public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] grid;
    static int min = Integer.MAX_VALUE;
    static int[] dir = new int[5]; // 판의 회전 방향
    static int[] order = new int[5]; // 쌓는 순서
    static boolean[] visit = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        grid = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        perm(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    // 1. 판을 회전 (총 4방향, 5개의 판 => 4^5 => 1024
    static void perm(int idx) {
        if (idx == 5) {
            perm2(0);
            return;
        }

        for (int d = 0; d < 4; d++) {
            dir[idx] = d;
            perm(idx + 1);
        }
    }

    // 2. 판 5개를 자유롭게 쌓음 => 5! => 120
    static void perm2(int idx) {
        if (idx == 5) {
            int[][][] tmp = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                tmp[i] = turn(grid[order[i]], dir[order[i]]);
            }
            bfs(tmp);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[idx] = i;
                perm2(idx + 1);
                visit[i] = false;
            }
        }
    }

    // 3. bfs 탐색
    static void bfs(int[][][] tmp) {
        if (tmp[0][0][0] == 0 || tmp[4][4][4] == 0) {
            return; // 진행 불가
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[5][5][5];
        queue.add(new int[]{0, 0, 0, 0});
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == 4 && current[1] == 4 && current[2] == 4) {
                min = Math.min(min, current[3]);
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                int nz = current[2] + dz[d];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || visit[nx][ny][nz] || tmp[nx][ny][nz] == 0) {
                    continue;
                }
                visit[nx][ny][nz] = true;
                queue.add(new int[]{nx, ny, nz, current[3] + 1});
            }
        }
    }

    static int[][] turn(int[][] arr, int count) {
        for (int c = 0; c < count; c++) {
            int[][] tmp = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    tmp[j][4 - i] = arr[i][j];
                }
            }
            arr = tmp;
        }
        return arr;
    }
}