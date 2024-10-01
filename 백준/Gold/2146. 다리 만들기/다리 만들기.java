import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2146 다리 만들기
public class Main {
    static int n;
    static int[][] country;
    static boolean[][] visit;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        country = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][n];
        int name = 0; // 대륙 라벨링
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && country[i][j] != 0) {
                    dfs(i, j, country[i][j], ++name);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // 라벨링한 도시 집단 별로 거리 계산
        for (int label = 1; label <= name; label++) {
            int tmp = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (label == country[i][j]) {
                        for (int k = 0; k < n; k++) {
                            for (int s = 0; s < n; s++) {
                                if (country[k][s] > label) {
                                    int distance = Math.abs(i - k) + Math.abs(j - s) - 1;
                                    tmp = Math.min(tmp, distance);
                                }
                            }
                        }
                    }
                }
            }
            min = Math.min(min, tmp);
        }
        System.out.println(min);
    }

    static void dfs(int x, int y, int label, int name) {
        visit[x][y] = true;
        country[x][y] = name; //label -> name
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                continue;
            }

            if (country[nx][ny] == label) {
                dfs(nx, ny, label, name);
            }
        }
    }
}