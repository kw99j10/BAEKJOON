import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//주난의 난
public class Main {
    static class Point implements Comparable<Point> {
        int x, y, jump;

        public Point(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }

        @Override
        public int compareTo(Point o) {
            return this.jump - o.jump;
        }
    }
    static int n, m, x1, y1, x2, y2;
    static int[][] room;
    static int[][] count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //주난이 위치
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;

        //범인 위치
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                room[i][j] = s.charAt(j) - '0';
            }
        }
        count = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[i][j] = INF;
            }
        }
        bfs(x1, y1);
    }
    static void bfs(int startX, int startY) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][m];

        queue.add(new Point(startX, startY, 0));
        visit[startX][startY] = true;
        count[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (x == x2 && y == y2) {
                System.out.println(count[x][y] + 14);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }

                if (count[nx][ny] > count[x][y] + room[nx][ny]) {
                    visit[nx][ny] = true;
                    count[nx][ny] = count[x][y] + room[nx][ny];
                    queue.add(new Point(nx, ny, count[nx][ny]));
                }
            }
        }
    }
}