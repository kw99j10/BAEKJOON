import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 16236 아기 상어
public class Main {
    static class Shark implements Comparable<Shark> {
        int x, y, distance;

        public Shark(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int compareTo(Shark s) {
            if (s.distance == this.distance) {
                if (s.x == this.x) {
                    return this.y - s.y;
                }
                return this.x - s.x;
            }
            return this.distance - s.distance; // 우선순위
        }
    }

    static int[][] space;
    static int n, sharkSize = 2, eatCount; // 상어 크기, 먹은 물고기 개수
    static int sx, sy, total; // 상어 위치, 시간
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    sx = i;
                    sy = j;
                    space[i][j] = 0; // 현재 상어 위치
                }
            }
        }

        do {
            isMove = false;
            bfs();
        } while (isMove);
        System.out.println(total);
    }

    static void bfs() {
        PriorityQueue<Shark> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Shark(sx, sy, 0));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Shark current = queue.poll();
            int x = current.x;
            int y = current.y;
            int distance = current.distance;

            // 자신보다 작은 크기 물고기만 먹을 수 있음
            if (space[x][y] != 0 && sharkSize > space[x][y]) {
                isMove = true;
                space[x][y] = 0;
                total += distance;
                eatCount++;
                sx = x;
                sy = y;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 자신보다 크기가 큰 물고기가 있는 칸은 지날 수 없음, 나머지 칸은 가능
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || space[nx][ny] > sharkSize) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Shark(nx, ny, distance + 1));
            }
        }

        // 자신의 크기와 같은 물고기를 먹을 때 크기 증가
        if (sharkSize == eatCount) {
            eatCount = 0;
            sharkSize++;
        }
    }
}
