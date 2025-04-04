import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17244 아맞다우산
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] home;
    static int[][] item;
    static int n, m, min, sx, sy, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        home = new char[m][n];
        item = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(item[i], -1);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                home[i][j] = s.charAt(j);
                if (home[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if (home[i][j] == 'X') {
                    item[i][j] = count++; // 비트마스킹 표시
                }
            }
        }
        size = (int) Math.pow(2, count);
        System.out.println(bfs() ? min : -1);
    }

    static boolean bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0, 0}); // 물건 상태, 최소 시간
        boolean[][][] visit = new boolean[m][n][size]; // 챙겨야 할 물건 개수
        visit[sx][sy][0] = true; // 비트 처리 필요
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int bit = current[2];
            int time = current[3];

            if (home[x][y] == 'E' && bit == size - 1) {
                min = time;
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || home[nx][ny] == '#' || visit[nx][ny][bit]) {
                    continue;
                }

                int next = bit;
                if (item[nx][ny] >= 0) {
                    next |= (1 << item[nx][ny]);
                }
                visit[nx][ny][next] = true;
                queue.add(new int[]{nx, ny, next, time + 1});
            }
        }
        return false;
    }
}