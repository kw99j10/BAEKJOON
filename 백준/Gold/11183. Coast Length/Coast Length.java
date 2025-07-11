import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 11183
class Main {
    static int n, m, count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (map[i][0] == 0) queue.add(new int[]{i, 0});
            if (map[i][m - 1] == 0) queue.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            if (map[0][j] == 0) queue.add(new int[]{0, j});
            if (map[n - 1][j] == 0) queue.add(new int[]{n - 1, j});
        }

        bfs(queue);

        checkCoast();
        System.out.println(count);
    }

    static void bfs(ArrayDeque<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (x < 0 || x >= n || y < 0 || y >= m || visit[x][y] || map[x][y] == 1) {
                continue;
            }
            visit[x][y] = true;
            for (int d = 0; d < 4; d++) {
                queue.add(new int[]{x + dx[d], y + dy[d]});
            }
        }
    }

    static void checkCoast() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (map[x][y] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny])
                            count++;
                    }
                }
            }
        }
    }
}