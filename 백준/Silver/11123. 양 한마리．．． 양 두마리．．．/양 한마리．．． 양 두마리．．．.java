import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static char[][] sheep;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            sheep = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    sheep[i][j] = s.charAt(j);
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (sheep[i][j] == '#') {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y) {
        sheep[x][y] = '.';

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                continue;
            }

            if (sheep[nx][ny] == '#') {
                dfs(nx, ny);
            }
        }
    }
}