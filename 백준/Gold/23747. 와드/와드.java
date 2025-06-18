import java.io.*;
import java.util.*;

// 23747 와드
class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] grid;
    static int[][] visit;
    static int visitNum = 1;
    static boolean[][] check;
    static int r, c, hr, hc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];
        visit = new int[r][c];
        check = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        hr = Integer.parseInt(st.nextToken()) - 1;
        hc = Integer.parseInt(st.nextToken()) - 1;

        String s = br.readLine();
        for (char ch : s.toCharArray()) {
            if (ch == 'W' && !check[hr][hc]) {
                bfs(hr, hc, grid[hr][hc]); // 격자의 같은 영역 모든 칸
                visitNum++;
            } else if (ch == 'U') {
                hr--;
            } else if (ch == 'D') {
                hr++;
            } else if (ch == 'L') {
                hc--;
            } else if (ch == 'R') {
                hc++;
            }
        }

        check[hr][hc] = true; // 한별이의 최종 위치 시야만 확보
        for (int d = 0; d < 4; d++) {
            int nx = hr + dx[d];
            int ny = hc + dy[d];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            check[nx][ny] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(check[i][j] ? "." : "#");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j, char area) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visit[i][j] = visitNum;
        check[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] == visitNum || grid[nx][ny] != area) {
                    continue;
                }
                visit[nx][ny] = visitNum;
                check[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}