import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1456 거의 소수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 거의 소수: a <= x <= b 의 개수
        boolean[] prime = new boolean[10000001];
        Arrays.fill(prime, true);
        prime[1] = false;

        //범위 내 소수 판별
        for (int i = 2; i <= 10000000; i++) {
            if (prime[i]) {
                for (int j = i + i; j <= 10000000; j += i) {
                    prime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i <= 10000000; i++) {
            if (prime[i]) {
                long tmp = (long) i * i; //소수의 n제곱
                while (true) {
                    if (tmp >= A && tmp <= B) {
                        cnt++;
                    }
                    if (tmp > B / i) {
                        break; //오버플로 방지
                    }
                    tmp *= i;
                }
            }
        }
        System.out.println(cnt);
    }
}