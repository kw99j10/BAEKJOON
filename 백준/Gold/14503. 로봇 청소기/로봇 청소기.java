import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r, c, d;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        visited[r][c] = true;
        cleaning(r, c, d);
        System.out.println(cnt);
    }

    private static void cleaning(int i, int j, int dir) {
        if (i < 0 || i >= n || j < 0 || j >= m || room[i][j] == 1) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            dir = (dir + 3) % 4;
            int robotI = i + dx[dir];
            int robotJ = j + dy[dir];
            if (robotI >= 0 && robotJ >= 0 && robotI < n && robotJ < m && !visited[robotI][robotJ]
                    && room[robotI][robotJ] == 0) {
                visited[robotI][robotJ] = true;
                cnt++;
                cleaning(robotI, robotJ, dir);
                return;
            }
        }

        int back = (dir + 2) % 4;
        int bx = i + dx[back];
        int by = j + dy[back];

        if (room[bx][by] != 1) {
            cleaning(bx, by, dir);
        }
    }
}
