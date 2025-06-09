import java.io.*;
import java.util.*;

// 29700 우당탕탕 영화예매
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        if (k > m) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += grid[i][j];
            }
            count = (sum == 0) ? count + 1 : count;

            for (int j = 1; j < m - k + 1; j++) {
                sum += grid[i][j + k - 1];
                sum -= grid[i][j - 1];
                count = (sum == 0) ? count + 1 : count;
            }
        }
        System.out.println(count);
    }
}