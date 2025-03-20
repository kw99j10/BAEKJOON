import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1018 체스판 다시 칠하기
public class Main {
    static int min = Integer.MAX_VALUE;
    static int n, m;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                min = Math.min(min, find(i, j));
            }
        }
        System.out.println(min);
    }

    static int find(int x, int y) {
        int countB = 0; // 흰 -> 검
        int countW = 0; // 검 -> 흰으로 바꿔야 하는 개수
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (grid[i][j] == 'B') {
                        countW++;
                    } else {
                        countB++;
                    }
                } else {
                    if (grid[i][j] == 'W') {
                        countW++;
                    } else {
                        countB++;
                    }
                }
            }
        }
        return Math.min(countW, countB);
    }
}
