import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1952 달팽이2
public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        int cnt = 0;
        int check = 0;
        int x = 0;
        int y = 0;
        int idx = 0;
        while (cnt != m * n - 1) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny]) {
                idx = (idx + 1) % 4;
                check++;
                continue;
            }

            x = nx;
            y = ny;
            visit[x][y] = true;
            cnt++;
        }
        System.out.println(check);
    }
}