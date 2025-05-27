import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 20165 인내의 도미노 장인 호석
public class Main {
    static int n, m, r, score;
    static int[][] grid;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; // 동서남북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visit = new boolean[n][m]; // 도미노 넘어졌는지 여부

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            attack(x, y, d);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            visit[x][y] = false; // x행 y열 도미노 다시 세움
        }

        System.out.println(score);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visit[i][j] ? "F " : "S ");
            }
            System.out.println();
        }
    }

    static void attack(int x, int y, String d) {

        if (visit[x][y]) {
            return; // 이미 넘어진 도미노
        }

        int dir = 0;
        switch (d) {
            case "E":
                dir = 0;
                break;
            case "W":
                dir = 1;
                break;
            case "S":
                dir = 2;
                break;
            case "N":
                dir = 3;
                break;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if (visit[cx][cy]) {
                continue;
            }
            visit[cx][cy] = true;
            score++;

            int len = grid[cx][cy];
            int nx = cx, ny = cy;
            for (int i = 0; i < len - 1; i++) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    break;
                }

                if (!visit[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}