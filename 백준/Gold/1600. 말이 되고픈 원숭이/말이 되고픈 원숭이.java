import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1600 말이 되고픈 원숭이
public class Main {
    static boolean[][][] visit;
    static int[][] horse = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}};
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int k, w, h, min = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit = new boolean[h][w][k + 1];

        queue.add(new int[]{0, 0, 0, k});
        visit[0][0][k] = true; // 벽 개수 감소

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int isPossible = current[3]; // 말처럼 움직일 수 있는 횟수

            if (x == h - 1 && y == w - 1) {
                min = Math.min(min, distance);
                return;
            }

            if (isPossible > 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = x + horse[d][0];
                    int ny = y + horse[d][1];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny][isPossible - 1] || map[nx][ny] == 1) {
                        continue;
                    }
                    visit[nx][ny][isPossible - 1] = true;
                    queue.add(new int[]{nx, ny, distance + 1, isPossible - 1});
                }
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny][isPossible]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    visit[nx][ny][isPossible] = true;
                    queue.add(new int[]{nx, ny, distance + 1, isPossible});
                }
            }
        }
    }
}