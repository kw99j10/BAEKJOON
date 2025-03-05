import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16724 피리 부는 사나이
public class Main {
    static int n, m, cnt;
    static char[][] map;
    static boolean[][] visit;
    static boolean[][] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visit = new boolean[n][m];
        cycle = new boolean[n][m]; // 사이클 여부 판단
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        
        visit[x][y] = true;
        int nx = x, ny = y;
        if (map[x][y] == 'U') {
            nx -= 1;
        } else if (map[x][y] == 'D') {
            nx += 1;
        } else if (map[x][y] == 'L') {
            ny -= 1;
        } else {
            ny += 1;
        }

        if (!visit[nx][ny]) {
            dfs(nx, ny);
        } else if (!cycle[nx][ny]) {
            cnt++;
        }
        cycle[x][y] = true; // 사이클 체크
    }
}