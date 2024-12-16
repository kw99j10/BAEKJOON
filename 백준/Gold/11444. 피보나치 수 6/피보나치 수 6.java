import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11444 피보나치 수 6
public class Main {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibo(n - 1)[0][0]);
    }

    static long[][] fibo(long n) {
        if (n == 1 || n == 0) {
            return new long[][]{{1, 1}, {1, 0}};
        }

        long[][] tmp = fibo(n / 2);

        if (n % 2 == 1L) {
            return matrix(matrix(tmp, tmp), new long[][]{{1, 1}, {1, 0}});
        } else {
            return matrix(tmp, tmp);
        }
    }

    static long[][] matrix(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];
        arr[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % MOD;
        arr[1][0] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % MOD;
        arr[0][1] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % MOD;
        arr[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % MOD;
        return arr;
    }
}