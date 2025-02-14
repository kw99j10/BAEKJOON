import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 17427 약수의 합 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 0L;
        for (int i = 1; i <= n; i++) {
            sum += (long) i * (n / i); // A = B/C  ==> n의 약수 = n/i
        }
        System.out.println(sum);
    }
}