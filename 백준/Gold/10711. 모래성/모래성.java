import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 10711 모래성
public class Main {
    static int h, w;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new char[h][w];
        for (int i = 0; i < h; i++) {
            board[i] = br.readLine().toCharArray();
        }
        bfs();
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // '모래성을 기준으로 큐에 담음
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == '.') {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '.') {
                        continue;
                    }
                    board[nx][ny]--;
                    if (board[nx][ny] == '0') {
                        board[nx][ny] = '.';
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }
        System.out.println(count - 1); // 마지막 날이 겹침
    }
}