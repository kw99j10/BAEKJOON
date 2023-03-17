import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * baekjoon 2004 조합 0의 개수
 *
 */
public class ComboZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // n!, (n-m)!, m! 의 승수를 구하여 최솟값을 출력한다.

        long count1 = five(n) - five(n - m) - five(m);
        long count2 = two(n) - two(n - m) - two(m);
        
        System.out.println(Math.min(count1, count2));
    }

    static long five(long t) {

        int count = 0;

        while(t >= 5) {
            count += t / 5;
            t /= 5;
        }
        return count;
    }

    static long two(long t){
        int count = 0;

        while(t >= 2) {
            count += t / 2;
            t /= 2;
        }
        return count;
    }
}
