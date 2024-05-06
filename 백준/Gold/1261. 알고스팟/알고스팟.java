import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//알고스팟
public class Main {
    static class Point implements Comparable<Point> {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return this.count - o.count; //부순 벽의 개수 최소화
        }
    }

    static int n, m;
    static int[][] maze;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][m];
        queue.add(new Point(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int count = current.count;

            if (cx == n - 1 && cy == m - 1) {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + move[d][0];
                int ny = cy + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;

                if (maze[nx][ny] == 0) {
                    queue.add(new Point(nx, ny, count));
                } else if (maze[nx][ny] == 1) {
                    queue.add(new Point(nx, ny, count + 1));
                }
            }
        }
    }
}