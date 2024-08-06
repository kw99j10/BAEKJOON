import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳
public class Main {
    static int r, c, answer;
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        if (r == 1 && c == 1) {
            System.out.println(1);
            return;
        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {
        if (visit[map[x][y] - 65]) {
            answer = Math.max(answer, cnt);
            return;
        }

        visit[map[x][y] - 65] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            dfs(nx, ny, cnt + 1);
        }
        visit[map[x][y] - 65] = false;
    }
}