import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9944 NXM 보드 완주하기
public class Main {
    static int n, m, min, total, sx, sy;
    static char[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 1;
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            grid = new char[n][m];

            total = 0;
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = s.charAt(j);
                    if (grid[i][j] == '.') {
                        sx = i;
                        sy = j;
                        total++;
                    }
                }
            }

            min = Integer.MAX_VALUE;

            if (total == 1) {
                min = 0; // 이동을 하지 않음
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == '.') {
                            for (int d = 0; d < 4; d++) {
                                visit = new boolean[n][m];
                                visit[i][j] = true;
                                dfs(i, j, d, 1, 1);
                            }
                        }
                    }
                }
            }
            sb.append("Case ").append(t++).append(": ").append(min == Integer.MAX_VALUE ? -1 : min).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y, int dir, int visitCount, int count) {
        if (visitCount == total) {
            min = Math.min(min, count);
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (!checkGrid(nx, ny)) {
            for (int d = 0; d < 4; d++) {
                if (d == dir) {
                    continue;
                }

                int tx = x + dx[d];
                int ty = y + dy[d];

                if (checkGrid(tx, ty)) {
                    dfs(x, y, d, visitCount, count + 1);
                }
            }
            return;
        }

        visit[nx][ny] = true;
        dfs(nx, ny, dir, visitCount + 1, count);
        visit[nx][ny] = false;
    }

    static boolean checkGrid(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '.' && !visit[nx][ny];
    }
}
