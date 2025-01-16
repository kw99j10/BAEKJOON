import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10830 행렬 제곱
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //nxn 행렬
        long b = Long.parseLong(st.nextToken()); //b 제곱

        long[][] grid = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        grid = divide(grid, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }

    // 행렬 곱셈
    static long[][] matrix(long[][] a, long[][] b) {
        long[][] mul = new long[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                long sum = 0L;
                for (int k = 0; k < a.length; k++) {
                    sum += (a[i][k] * b[k][j]) % 1000;
                }
                mul[i][j] = sum % 1000;
            }
        }
        return mul;
    }

    static long[][] divide(long[][] tmp, long b) {
        if (b == 1) {
            return tmp;
        }

        long[][] memo = divide(tmp, b / 2);
        return b % 2 == 1 ? matrix(matrix(memo, memo), tmp) : matrix(memo, memo);
    }
}