import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 5212 지구 온난화
public class Main {
    static int r, c, maxIdxR, maxIdxC, minIdxR = 11, minIdxC = 11;
    static char[][] map;
    static int[][] tmp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    check(i, j);
                }
            }
        }

        sink(); // 땅이 바다에 잠김
        cut(); //지도 크기를 줄임

        for (int i = minIdxR; i < maxIdxR + 1; i++) {
            for (int j = minIdxC; j < maxIdxC + 1; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void cut() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    minIdxR = Math.min(minIdxR, i);
                    minIdxC = Math.min(minIdxC, j);

                    maxIdxR = Math.max(maxIdxR, i);
                    maxIdxC = Math.max(maxIdxC, j);
                }
            }
        }
    }

    private static void sink() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = tmp[i][j] >= 3 ? '.' : 'X';
                }
            }
        }
    }

    static void check(int x, int y) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '.') {
                count++;
            }
        }
        tmp[x][y] = count;
    }
}