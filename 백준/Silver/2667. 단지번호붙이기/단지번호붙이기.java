import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// 2667 : 단지번호붙이기
class Main {

    static int n, count;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    lists.add(count);
                }
            }
        }

        Collections.sort(lists);
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list).append("\n");
        }
        System.out.println(lists.size());
        System.out.print(sb);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        count++;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] == 0) {

                continue;
            }
            dfs(nx, ny);
        }
    }
}