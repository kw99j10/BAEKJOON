import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11442 홀수번째 피보나치 수의 합
public class Main {
    static long[][] fibo = {{1, 1}, {1, 0}};
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n % 2 == 1) {
            n += 1;
        }
        long[][] tmp = fibo(fibo, n);
        System.out.println(tmp[1][0]);
    }

    public static long[][] fibo(long[][] tmp, long exp) {
        if (exp == 1) {
            return tmp;
        }

        long[][] res = fibo(tmp, exp / 2);

        if (exp % 2 == 1) {
            return matrix(matrix(res, res), tmp);
        } else {
            return matrix(res, res);
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
