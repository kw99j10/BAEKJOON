import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16933 벽 부수고 이동하기 3
public class Main {
    static int n, m, k, min = Integer.MAX_VALUE;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][][][] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit = new boolean[n][m][k + 1][2]; // 낮:0, 밤:1

        queue.add(new int[]{0, 0, 0, k, 0}); // 처음은 낮
        visit[0][0][k][0] = true; // 벽 개수 감소

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int isBroken = current[3];
            int days = current[4];

            if (distance > min) {
                continue; //가지치기
            }
            int next = (days + 1) % 2; //낮과 밤이 계속 바뀜

            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, distance + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];
                if (nx < 0 || nx >= n || ny < 0 | ny >= m) {
                    continue;
                }

                //1. 벽인 경우
                if (map[nx][ny] == 1) {
                    // 1-1. 낮인 경우
                    if (days == 0 && isBroken > 0 && !visit[nx][ny][isBroken - 1][1]) {
                        visit[nx][ny][isBroken - 1][1] = true;
                        queue.add(new int[]{nx, ny, distance + 1, isBroken - 1, 1});
                    }

                    // 1-2. 밤인 경우
                    else if (days == 1 && !visit[x][y][isBroken][0]) {
                        visit[x][y][isBroken][0] = true;
                        queue.add(new int[]{x, y, distance + 1, isBroken, 0});
                    }
                }

                //2. 벽이 아닌 경우 => 낮과 밤 상관 없이 이동 가능
                if (map[nx][ny] == 0 && !visit[nx][ny][isBroken][next]) {
                    visit[nx][ny][isBroken][next] = true;
                    queue.add(new int[]{nx, ny, distance + 1, isBroken, next});
                }
            }
        }
    }
}