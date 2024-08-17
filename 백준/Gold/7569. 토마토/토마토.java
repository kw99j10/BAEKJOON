import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Tomato {
        int x; //가로
        int y; //세로
        int h; //높이
        int days; //익는 시간

        public Tomato(int x, int y, int h, int days) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.days = days;
        }
    }

    static int m, n, h; //가로, 세로, 높이
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] box; //토마토를 담을 상자
    static ArrayDeque<Tomato> queue; //토마토를 담을 큐
    static int minDays; //최소 며칠?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[n][m][h];
        queue = new ArrayDeque<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    //익은 토마토를 큐에 담음
                    if (box[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k, 0));
                    }
                }
            }
        }
        
        bfs(); //너비우선 탐색 수행
        System.out.println(minDays);
    }
    static void bfs() {
        int days = 0;
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            for (int d = 0; d < 6; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                int nz = current.h + dz[d];
                days = current.days;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {
                    if (box[nx][ny][nz] == 0) {
                        box[nx][ny][nz] = 1;
                        queue.add(new Tomato(nx, ny, nz, current.days + 1));
                    }
                }
            }
        }

        boolean zeroTomato = false; //익지 않은 토마토의 개수

        for (int[][] tomato : box) {
            for (int[] piece : tomato) {
                for (int i : piece) {
                    if (i == 0) {
                        zeroTomato = true;
                        break; //토마토가 모두 익지 못하는 상황
                    }
                }
            }
        }
        minDays = zeroTomato ? -1 : days;
    }
}
