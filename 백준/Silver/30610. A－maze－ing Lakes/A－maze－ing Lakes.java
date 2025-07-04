import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 30610
class Main {
    static int r, c, size;
    static char[][] maze;
    static boolean[][] visit;
    static ArrayList<Integer> lists = new ArrayList<>();
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

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j] && maze[i][j] == '1') {
                    size = 1;
                    bfs(i, j);
                    lists.add(size);
                }
            }
        }
        Collections.sort(lists);
        System.out.println(lists.size());
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || maze[nx][ny] == '0') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                size++;
            }
        }
    }
}