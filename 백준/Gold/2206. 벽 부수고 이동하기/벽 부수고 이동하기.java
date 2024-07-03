import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = Integer.MAX_VALUE; //최단 거리

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

        //출발지와 도착지는 항상 0
        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[n][m][2];

        //0:벽을 부수지 않음, 1: 벽을 부숨
        queue.add(new int[]{0, 0, 1, 0}); //좌표, 최단 경로, 벽을 부순지 여부
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            int broken = current[3];

            if (x == n - 1 && y == m - 1) {
                ans = Math.min(ans, time);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visit[nx][ny][broken]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    visit[nx][ny][broken] = true;
                    queue.add(new int[]{nx, ny, time + 1, broken});
                } else if (map[nx][ny] == 1 && broken == 0) {
                    visit[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, time + 1, 1});
                }
            }
        }
    }
}