import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 2206 벽 부수고 이동하기
public class Main {
    static boolean[][][] visit;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m, min = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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
        visit = new boolean[n][m][2];

        queue.add(new int[]{0, 0, 0, 0}); //x,y,거리, 부숨 여부
        visit[0][0][0] = true; // 벽 안 부숨:0, 벽 부숨: 1

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int isBroken = current[3];

            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, distance + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny][isBroken]) {
                    continue;
                }

                if (isBroken == 0 && map[nx][ny] == 1) {
                    visit[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, distance + 1, 1});
                } else if (map[nx][ny] == 0) {
                    visit[nx][ny][isBroken] = true;
                    queue.add(new int[]{nx, ny, distance + 1, isBroken});
                }
            }
        }
    }
}