import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 10711 모래성
public class Main {
    static int h, w;
    static ArrayDeque<int[]> addQ;
    static char[][] board;
    static int[][] sand;
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

        sand = new int[h][w];
        addQ = new ArrayDeque<>();
        countSand(); // 주변 모래 개수 카운트

        int count = 0;
        while (bfs()) {
            count++;
        }
        System.out.println(count);
    }

    // 무너질 초기 모래를 담은 후 무너진 모래 주변으로 무너진 모래 개수를 카운팅하며 bfs 탐색
    static void countSand() {
        for (int i = 0; i < h * w; i++) {
            int x = i / w;
            int y = i % w;

            int cnt = 0;
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (check(nx, ny) && board[nx][ny] == '.') {
                    cnt++;
                }
            }
            sand[x][y] = cnt;
            if (board[x][y] != '.' && cnt >= board[x][y] - '0') {
                addQ.add(new int[]{x, y});
            }
        }
    }

    static boolean bfs() {
        ArrayDeque<int[]> delQ = new ArrayDeque<>();
        boolean isSame = true;

        while (!addQ.isEmpty()) {
            int[] current = addQ.poll();
            int x = current[0];
            int y = current[1];

            board[x][y] = '.'; // 모래성 무너짐
            isSame = false;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!check(nx, ny) || board[nx][ny] == '.') {
                    continue;
                }

                sand[nx][ny]++;
                if (sand[nx][ny] == board[nx][ny] - '0') {
                    delQ.add(new int[]{nx, ny}); // 무너질 모래성
                }
            }
        }

        addQ = delQ;
        return !isSame;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}