import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2468 안전 영역
public class Main {
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, min = 101, max, count;
    static int[][] area;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }

        if (min == max) {
            System.out.println(1);
            return;
        }

        // t 이하 잠김 잠기지 않은 영역 개수 최대 구하기
        for (int t = min; t <= max; t++) {

            visit = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && area[i][j] > t) {
                        dfs(i, j, t); // 현재 높이에 대해서 dfs
                        cnt++;
                    }
                }
            }
            count = Math.max(count, cnt);
        }
        System.out.println(count);
    }

    static void dfs(int i, int j, int h) {
        visit[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int nx = i + move[d][0];
            int ny = j + move[d][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                continue;
            }

            if (area[nx][ny] > h) {
                visit[nx][ny] = true;
                dfs(nx, ny, h);
            }
        }
    }
}