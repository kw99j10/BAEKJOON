import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 25682 체스판 다시 칠하기 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                grid[i][j] = (s.charAt(j - 1) == 'B') ? 1 : 0;
            }
        }

        int[][] black = new int[n + 1][m + 1]; // 검은색부터
        int[][] white = new int[n + 1][m + 1]; // 흰색부터
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                black[i][j] = ((i + j) % 2 == 0) ? 1 : 0; // b:1
                white[i][j] = ((i + j) % 2 == 0) ? 0 : 1; // w:0
            }
        }

        // 현재 판과 비교하여 칠할 보드가 있는지 비교
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                black[i][j] = (grid[i][j] + black[i][j]) % 2 == 0 ? 0 : 1;
                white[i][j] = (grid[i][j] + white[i][j]) % 2 == 0 ? 0 : 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                black[i][j] += black[i - 1][j] + black[i][j - 1] - black[i - 1][j - 1];
                white[i][j] += white[i - 1][j] + white[i][j - 1] - white[i - 1][j - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                int wCnt = white[i + k - 1][j + k - 1] - white[i + k - 1][j - 1] - white[i - 1][j + k - 1] + white[i - 1][j - 1];
                int bCnt = black[i + k - 1][j + k - 1] - black[i + k - 1][j - 1] - black[i - 1][j + k - 1] + black[i - 1][j - 1];
                min = Math.min(min, Math.min(wCnt, bCnt));
            }
        }
        System.out.println(min);
    }
}
