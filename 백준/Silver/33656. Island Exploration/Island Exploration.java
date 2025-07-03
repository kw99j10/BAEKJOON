import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 33656
class Main {
    static int r, c, sx, sy;
    static char[][] maze;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = s.charAt(j);

                if (maze[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[r][c];
        visit[i][j] = true;
        queue.add(new int[]{i, j, 0});

        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || maze[nx][ny] == '.') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        System.out.println(count);
    }
}