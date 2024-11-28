import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 1926 그림
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m, count;
    static int[][] grid;
    static ArrayList<Integer> lists = new ArrayList<>(); // 그림을 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    lists.add(count);
                }
            }
        }
        Collections.sort(lists);
        System.out.println(lists.size());
        System.out.println(lists.isEmpty() ? 0 : lists.get(lists.size() - 1));
    }

    static void dfs(int x, int y) {
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
        }
        count += 1;
    }
}