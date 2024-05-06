import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다리 만들기
public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][n];

        int name = 1; //대륙 별로 분류
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j, map[i][j], name);
                    name++;
                }
            }
        }

        int totalMin = Integer.MAX_VALUE; //total 짧은 다리의 길이
        //대륙의 개수만큼 반복문 수행
        for (int c = 1; c <= name; c++) {
            int min = Integer.MAX_VALUE; //현재 짧은 다리의 길이
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == c) {
                        for (int k = 0; k < n; k++) {
                            for (int s = 0; s < n; s++) {
                                //다른 대륙 발견
                                if (map[k][s] > c) {
                                    int distance = Math.abs(i - k) + Math.abs(j - s) - 1;
                                    min = Math.min(min, distance);
                                }
                            }
                        }
                    }
                }
            }
            totalMin = Math.min(totalMin, min);
        }
        System.out.println(totalMin);
    }

    static void dfs(int x, int y, int old, int newName) {

        visit[x][y] = true;
        map[x][y] = newName;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == old) {
                visit[nx][ny] = true;
                dfs(nx, ny, old, newName);
            }
        }
    }
}