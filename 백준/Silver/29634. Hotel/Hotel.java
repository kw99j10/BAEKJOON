import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 29634
class Main {
    static int r, c;
    static char[][] maze;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];
        visit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maze[i][j] == '*' && !visit[i][j]) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(max == 0 ? -1 : max);
    }

    static int bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[i][j] = true;
        queue.add(new int[]{i, j});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];


            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || maze[nx][ny] == '*') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }
}