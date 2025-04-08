import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1726 로봇
public class Main {
    static class Robot {
        int x, y, dir, order;

        public Robot(int x, int y, int dir, int order) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.order = order;
        }
    }

    static int n, m, sx, sy, sd, ex, ey, ed, min = Integer.MAX_VALUE;
    static int[][] grid;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        sd = Integer.parseInt(st.nextToken());
        sd = changeDir(sd);

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;
        ed = Integer.parseInt(st.nextToken());
        ed = changeDir(ed);

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        ArrayDeque<Robot> queue = new ArrayDeque<>();
        queue.add(new Robot(sx, sy, sd, 0));
        boolean[][][] visit = new boolean[m][n][4];
        visit[sx][sy][sd] = true;

        while (!queue.isEmpty()) {
            Robot current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dir = current.dir;
            int count = current.order;

            if (x == ex && y == ey && dir == ed) {
                min = Math.min(min, count);
                return;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) { // 명령 1: 1~3만큼 앞으로 이동
                    for (int j = 1; j <= 3; j++) {
                        int nx = x + move[dir][0] * j;
                        int ny = y + move[dir][1] * j;
                        if (checkGrid(nx, ny) || grid[nx][ny] == 1) {
                            break;
                        }
                        if (!visit[nx][ny][dir]) {
                            visit[nx][ny][dir] = true;
                            queue.add(new Robot(nx, ny, dir, count + 1));
                        }
                    }
                } else { // 명령 2: 왼쪽 또는 오른쪽 으로 90도 회전
                    for (int j = 0; j < 2; j++) {
                        int nextDir = (j == 0) ? (dir + 3) % 4 : (dir + 1) % 4;
                        if (!visit[x][y][nextDir]) {
                            visit[x][y][nextDir] = true;
                            queue.add(new Robot(x, y, nextDir, count + 1));
                        }
                    }
                }
            }
        }
    }

    static int changeDir(int dir) {
        if (dir == 1) return 0;
        if (dir == 2) return 2;
        if (dir == 3) return 1;
        return 3;
    }

    static boolean checkGrid(int nx, int ny) {
        return nx < 0 || nx >= m || ny < 0 || ny >= n;
    }
}