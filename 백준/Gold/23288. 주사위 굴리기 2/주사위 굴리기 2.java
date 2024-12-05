import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 23288 주사위 굴리기 2
public class Main {
    static int n, m, k, sx, sy, count, sum;
    static int[][] map;
    static boolean[][] visit;
    static int[] dice = {0, 2, 4, 1, 3, 5, 6};
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동 -> 남 -> 서 -> 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sx = 0;
        sy = 0;
        int dir = 0;
        for (int i = 0; i < k; i++) {

            int nx = sx + move[dir][0];
            int ny = sy + move[dir][1];

            // 1. 주사위가 이동 방향으로 한 칸, 칸이 없다면 반대 방향으로 한 칸
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                roll(dir);
            } else {
                dir = (dir + 2) % 4;
                roll(dir);
                nx = sx + move[dir][0];
                ny = sy + move[dir][1];
            }
            sx = nx;
            sy = ny;

            //2. 주사위가 도착한 칸에 대해 방향 결정
            int score = map[sx][sy];

            // 아랫면 a > 칸 정수 b => 시계 방향 회전
            if (dice[6] > score) {
                dir = (dir + 1) % 4;
            }

            // 아랫면 a < 칸 정수 b => 반시계 방향 회전
            else if (score > dice[6]) {
                dir = (dir + 3) % 4;
            }

            //3. 점수 획득 방법
            // 동서남북으로 정수 B가 있는 경우를 계속 탐색
            // 점수 = b가 나온 갯수 C x B
            count = 0;
            visit = new boolean[n][m];
            dfs(sx, sy);
            sum += (count * score);
        }
        System.out.println(sum);
    }

    static void dfs(int x, int y) {
        int num = map[x][y];
        visit[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nnx = x + move[d][0];
            int nny = y + move[d][1];

            if (nnx < 0 || nnx >= n || nny < 0 || nny >= m || visit[nnx][nny]) {
                continue;
            }
            if (num == map[nnx][nny]) {
                dfs(nnx, nny);
            }
        }
        count++;
    }

    static void roll(int dir) {
        // 초기 주사위 (윗 면:1, 동쪽 면:3)
        int tmp;
        switch (dir) {
            case 0:
                tmp = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = tmp;
                break; // 동쪽
            case 1:
                tmp = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;
                break; // 남쪽
            case 2:
                tmp = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = tmp;
                break; // 서쪽
            case 3:
                tmp = dice[6];
                dice[6] = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[5];
                dice[5] = tmp;
                break; // 북쪽
        }
    }
}
