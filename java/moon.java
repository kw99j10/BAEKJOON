import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//1194. 달이 차오른다, 가자.
public class Main {
    static class Point {
        int x, y, bit, time;

        public Point(int x, int y, int bit, int time) {
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.time = time;
        }
    }

    static int n, m, sx, sy, answer = Integer.MAX_VALUE;
    static char[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j);

                if (maze[i][j] == '0') {
                    sx = i;
                    sy = j;
                    maze[i][j] = '.';
                }
            }
        }
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs() {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[n][m][64]; //2^6 비트마스킹
        queue.add(new Point(sx, sy, 0, 0));
        visit[sx][sy][0] = true; //현재 민식이의 위치

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            int bit = current.bit;
            int time = current.time;

            if (maze[x][y] == '1') {
                answer = time;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny][bit] || maze[nx][ny] == '#') {
                    continue;
                }

                int tmpBit = bit;

                //1. 열쇠 별로 방문 배열 저장
                if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    tmpBit |= (1 << (maze[nx][ny] - 'a'));
                }

                //2. 해당 열쇠가 있다면 문을 이동할 수 있음
                else if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') {
                    if ((bit & (1 << (maze[nx][ny] - 'A'))) == 0) {
                        continue; // 해당 문을 열 수 없는 경우 스킵
                    }
                }

                visit[nx][ny][tmpBit] = true;
                queue.add(new Point(nx, ny, tmpBit, time + 1));
            }
        }
    }
}
