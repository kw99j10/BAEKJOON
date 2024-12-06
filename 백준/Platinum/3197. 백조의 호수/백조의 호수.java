import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 3197 백조의 호수
class Main {
    static int r, c, sx, sy, ex, ey, days;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayDeque<int[]> moveBirds = new ArrayDeque<>(); // 백조의 이동 가능 경로
    static ArrayDeque<int[]> water = new ArrayDeque<>(); // 빙하와 인접한 물
    static char[][] lake; // 호수
    static boolean[][] visit; // 백조가 방문한 경로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        lake = new char[r][c];

        boolean isFirst = true;
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = s.charAt(j);
                lake[i][j] = c;

                if (c == '.') {
                    water.add(new int[]{i, j}); // 물 정보
                }

                if (c == 'L') {
                    if (isFirst) {
                        sx = i;
                        sy = j;
                        isFirst = false;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    lake[i][j] = '.'; // 백조 위치를 물로 치환 후 담음
                    water.add(new int[]{i, j});
                }
            }
        }

        visit = new boolean[r][c];
        visit[sx][sy] = true;
        moveBirds.add(new int[]{sx, sy});

        while (!find()) {
            bfs(); // 백조가 만날 때까지 빙하를 녹임
            days++;
        }
        System.out.println(days);
    }

    static boolean find() {
        ArrayDeque<int[]> tmp = new ArrayDeque<>(); // 다음 이동 갱신 큐

        // 이동할 수 없을 때까지 이동
        while (!moveBirds.isEmpty()) {
            int[] current = moveBirds.poll();
            int x = current[0];
            int y = current[1];

            if (x == ex && y == ey) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;

                // 빙하는 다음 번에 이동
                if (lake[nx][ny] == 'X') {
                    tmp.add(new int[]{nx, ny});
                }

                // 물은 다시 담음
                else if (lake[nx][ny] == '.') {
                    moveBirds.add(new int[]{nx, ny});
                }
            }
        }

        moveBirds = tmp; // 이동이 끝나면 갱신
        return false;
    }

    static void bfs() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            int[] current = water.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }

                // 물과 접한 곳이 빙하일 경우 녹인 후 큐에 담음
                if (lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    water.add(new int[]{nx, ny});
                }
            }
        }
    }
}