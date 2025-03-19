import java.io.*;
import java.util.*;

// 16507 어두운 건 무서워
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] grid = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()) + grid[i][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            int size = (c2 - c1 + 1) * (r2 - r1 + 1);
            for (int j = r1; j <= r2; j++) {
                sum += grid[j][c2] - grid[j][c1 - 1];
            }
            sb.append(sum / size).append("\n");
        }
        System.out.print(sb);
    }
}
