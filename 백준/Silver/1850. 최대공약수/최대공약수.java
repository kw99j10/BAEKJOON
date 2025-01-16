import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1850 최대 공약수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a,b 는 각각 1의 개수
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int tmp = (int) gcd(a, b);
        System.out.print("1".repeat(Math.max(0, tmp)));
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}