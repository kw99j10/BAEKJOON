import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//미친 로봇
public class Main {
    static int n;
    static double answer;
    static double[] move = new double[4];
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            move[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        visit = new boolean[30][30];
        dfs(15, 15, 1, 0);
        System.out.print(answer);
    }

    static void dfs(int x, int y, double sum, int cnt) {
        if (cnt == n) {
            answer += sum;
            return;
        }

        visit[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= 30 || ny < 0 || ny >= 30 || visit[nx][ny]) {
                continue;
            }

            visit[nx][ny] = true;
            dfs(nx, ny, sum * move[d], cnt + 1);
            visit[nx][ny] = false;
        }
    }
}
