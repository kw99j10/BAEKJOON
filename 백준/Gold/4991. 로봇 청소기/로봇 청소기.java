import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4991 로봇 청소기
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] room;
    static int[][] clean;
    static int n, m, sx, sy, size;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            room = new char[m][n];
            clean = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(clean[i], -1);
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    room[i][j] = s.charAt(j);
                    if (room[i][j] == 'o') {
                        sx = i;
                        sy = j;
                    }
                    if (room[i][j] == '*') {
                        clean[i][j] = count++; // 비트마스킹 표시
                    }
                }
            }
            size = (int) Math.pow(2, count);
            bfs();
        }
        System.out.print(sb);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0, 0}); // 칸 청소, 이동 횟수
        boolean[][][] visit = new boolean[m][n][size];
        visit[sx][sy][0] = true; // 비트 처리 필요

        int min = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int bit = current[2];
            int count = current[3];

            if (bit == size - 1) {
                min = count;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || room[nx][ny] == 'x' || visit[nx][ny][bit]) {
                    continue;
                }

                int next = bit;
                if (clean[nx][ny] >= 0) {
                    room[nx][ny] = '.';
                    next |= (1 << clean[nx][ny]);
                }
                visit[nx][ny][next] = true;
                queue.add(new int[]{nx, ny, next, count + 1});
            }
        }

        boolean isClean = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] == '*') {
                    isClean = false;
                    break;
                }
            }
            if (!isClean) {
                break;
            }
        }
        sb.append(isClean ? min : -1).append("\n");
    }
}