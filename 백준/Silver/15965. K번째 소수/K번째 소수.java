import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 15965 K번째 소수
public class Main {
    static final int V = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[15 * V + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(15 * V); i++) {
            for (int j = i * i; j <= 15 * V; j += i) {
                isPrime[j] = false;
            }
        }

        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 1; i <= 15 * V; i++) {
            if (isPrime[i]) {
                lists.add(i);
            }
        }
        System.out.println(lists.get(k - 1));
    }
}