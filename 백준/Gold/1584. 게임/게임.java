import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1584 게임
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;
    static int[][] map = new int[501][501];

    static class Game implements Comparable<Game> {
        int x, y, life;
        public Game(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
        }

        @Override
        public int compareTo(Game o) {
            return this.life - o.life;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //위험한 구역 수
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    map[j][k] = 1; //위험 구역 표시
                }
            }
        }

        int m = Integer.parseInt(br.readLine()); //죽음의 구역 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    map[j][k] = -1; //위험 구역 표시
                }
            }
        }
        answer = -1;
        bfs();
        System.out.println(answer);
    }
    static void bfs() {
        PriorityQueue<Game> queue = new PriorityQueue<>();
        queue.add(new Game(0, 0, 0)); // x좌표, y좌표, 생명력
        boolean[][] visit = new boolean[501][501];
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Game current = queue.poll();
            int x = current.x;
            int y = current.y;
            int life = current.life;
            if (x == 500 && y == 500) {
                answer = life;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx > 500 || ny < 0 || ny > 500 || visit[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                map[nx][ny] += life;
                queue.add(new Game(nx, ny, map[nx][ny]));
            }
        }
    }
}