import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    static int n, curX, curY, sharkSize = 2, eatCount, time;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    curX = i;
                    curY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            boolean flag = false;

            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) {
                    return Integer.compare(o1[2], o2[2]);
                } else if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            boolean[][] visit = new boolean[n][n];
            visit[curX][curY] = true;
            queue.add(new int[]{curX, curY, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int distance = current[2];

                if (map[x][y] != 0 && sharkSize > map[x][y]) {
                    map[x][y] = 0;
                    eatCount++;
                    time += distance;
                    curX = x;
                    curY = y;
                    flag = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                        continue;
                    }

                    if (map[nx][ny] > sharkSize) {
                        continue;
                    }
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }

            if (!flag) {
                break;
            }

            if (sharkSize == eatCount) {
                sharkSize++;
                eatCount = 0;
            }
        }
        System.out.println(time);
    }
}
