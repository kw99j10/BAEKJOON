import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//6588 골드바흐의 추측
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            for (int j = i * i; j <= 1000000; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int maxI = 0;
            int maxJ = 0;
            for (int i = 3; i <= n; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    maxI = i;
                    maxJ = n - i;
                    break;
                }
            }
            if (maxI == 0 || maxJ == 0) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            } else {
                sb.append(n).append(" = ").append(maxI).append(" + ").append(maxJ).append("\n");
            }
        }
        System.out.print(sb);
    }
}