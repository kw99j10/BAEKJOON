import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2436 공약수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 어떤 두 자연수의 최대공약수
        int b = Integer.parseInt(st.nextToken()); // 어떤 두 자연수의 최소공배수

        long mul = (long) a * b;
        long t1 = 0;
        long t2 = 0;
        for (int i = a; i <= Math.sqrt(mul); i += a) {
            if (mul % i == 0 && gcd(i, (int) (mul / i)) == a) {
                t1 = i;
                t2 = mul / i;
            }
        }
        System.out.println(t1 + " " + t2);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}