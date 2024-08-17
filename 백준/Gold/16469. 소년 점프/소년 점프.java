import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16469 소년 점프
public class Main {
    static class Boy {
        int x, y, count;
        boolean[][] visit;

        public Boy(int x, int y, int count, boolean[][] visit) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.visit = visit;
        }
    }

    static int r, c, min = Integer.MAX_VALUE, cnt;
    static int[][] maze;
    static int[][] total;
    static ArrayDeque<Boy> queue;
    static int[] dx = {1, -1, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new int[r][c];
        total = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = s.charAt(j) - '0';
                if (maze[i][j] == 1) {
                    maze[i][j] = -1;
                }
            }
        }

        queue = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new Boy(x, y, 0, new boolean[r][c]));
            maze[x][y] = 1; // 현재 좌표에 위치
        }
        bfs();

        // 같은 거리의 지점 개수
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (total[i][j] != 0 && min > total[i][j]) {
                    min = total[i][j];
                    cnt = 1;
                } else if (min == total[i][j]) {
                    cnt++;
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : (min + "\n" + cnt));
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            Boy current = queue.poll();
            int x = current.x;
            int y = current.y;
            int time = current.count;
            boolean[][] visit = current.visit;
            visit[x][y] = true;
            for (int d = 0; d < 5; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || maze[nx][ny] == -1 || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                maze[nx][ny]++;
                queue.add(new Boy(nx, ny, time + 1, visit));

                if (maze[nx][ny] == 3) {
                    total[nx][ny] = time + 1;
                }
            }
        }
    }
}