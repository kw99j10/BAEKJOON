import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 18484 현명한 나이트
public class Main {
    static int n;
    static int[][] grid;
    static int[][] move = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
    static ArrayList<int[]> list;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        count = new int[m];
        bfs(sx, sy);
        StringBuilder sb = new StringBuilder();
        for (int i : count) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[x][y] = true;
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cnt = current[2];

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] == cx && list.get(i)[1] == cy) {
                    count[i] = cnt;
                }
            }

            for (int d = 0; d < 8; d++) {
                int nx = cx + move[d][0];
                int ny = cy + move[d][1];

                if (nx <= 0 || nx > n || ny <= 0 || ny > n || visit[nx][ny]) {
                    continue;
                }
                queue.add(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
            }
        }
    }
}