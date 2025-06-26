import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 15240

class Main {
    static int r, c, sx, sy, k;
    static int[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs(sx, sy);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(maze[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[r][c];
        visit[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];


            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || maze[nx][ny] != maze[x][y]) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        for (int t = 0; t < r; t++) {
            for (int s = 0; s < c; s++) {
                if (visit[t][s]) {
                    maze[t][s] = k;
                }
            }
        }
    }
}