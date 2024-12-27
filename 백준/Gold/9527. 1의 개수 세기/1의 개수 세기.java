import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9527 1의 개수 세기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(count(b) - count(a - 1));
    }

    // 비트 패턴 이용 (2^n)
    static long count(long x) {
        long count = 0; // 1의 개수
        long bit = 1; // 2^bit
        while (bit <= x) {
            long divider = x / (bit * 2);
            count += divider * bit;

            long divided = x % (bit * 2);
            count += Math.max(0, divided - bit + 1);

            bit *= 2;
        }
        return count;
    }
}
