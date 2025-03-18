import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 16924 십자가 찾기
public class Main {
    static int n, m, cnt;
    static boolean[][] visit;
    static ArrayList<int[]> lists = new ArrayList<>();
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    cross(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*' && !visit[i][j]) {
                    System.out.println(-1); // 방문하지 않은 십자가 요소가 있는 경우
                    return;
                }
            }
        }

        System.out.println(lists.size());
        StringBuilder sb = new StringBuilder();
        for (int[] list : lists) {
            sb.append(list[0]).append(" ").append(list[1]).append(" ").append(list[2]).append("\n");
        }
        System.out.print(sb);
    }

    static void cross(int x, int y) {
        int ux = x, dx = x, ly = y, ry = y;
        int size = 0;
        while (true) {
            boolean isPossible = false;
            ux -= 1;
            dx += 1;
            ly -= 1;
            ry += 1;

            if (check(ux, y) && check(dx, y) && check(x, ly) && check(x, ry)) {
                isPossible = true;
                size++;
            }

            if (isPossible) {
                visit[x][y] = true;
                visit[ux][y] = true;
                visit[dx][y] = true;
                visit[x][ly] = true;
                visit[x][ry] = true;
                lists.add(new int[]{x + 1, y + 1, size});
                cnt++;
            } else {
                break;
            }
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '*';
    }
}