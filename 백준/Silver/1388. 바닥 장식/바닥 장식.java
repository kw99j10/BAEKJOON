import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1388 바닥 장식
public class Main {
    static int n, m, count;
    static char[][] grid;
    static boolean[][] visit;

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
                if (!visit[i][j]) {
                    search(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void search(int x, int y) {
        if (grid[x][y] == '-') {
            for (int d = y; d < m; d++) {
                if (grid[x][y] != grid[x][d]) {
                    break;
                }
                visit[x][d] = true;
            }
        } else {
            for (int d = x; d < n; d++) {
                if (grid[x][y] != grid[d][y]) {
                    break;
                }
                visit[d][y] = true;
            }
        }
        count++;
    }
}