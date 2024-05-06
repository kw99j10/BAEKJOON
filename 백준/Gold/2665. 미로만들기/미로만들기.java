import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//미로 만들기
public class Main {
    static class Maze implements Comparable<Maze> {
        int x, y, black;

        public Maze(int x, int y, int black) {
            this.x = x;
            this.y = y;
            this.black = black;
        }

        @Override
        public int compareTo(Maze o) {
            return this.black - o.black; //검은색으로 바꿔야 할 방의 개수
        }
    }

    static int n;
    static int[][] room;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        room = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        PriorityQueue<Maze> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Maze(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Maze current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int count = current.black;

            if (cx == n - 1 && cy == n - 1) {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + move[d][0];
                int ny = cy + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;

                if (room[nx][ny] == 1) {
                    queue.add(new Maze(nx, ny, count));
                } else if (room[nx][ny] == 0) {
                    queue.add(new Maze(nx, ny, count + 1));
                }
            }
        }
    }
}