import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1790 수 이어 쓰기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        int num = 0;
        long post = 0, next = 1;
        while (k > 0) {
            post = k;
            k -= (long) (Math.pow(10, num) * next * 9);
            num++;
            next++;
        }
        long result = (long) (Math.pow(10, num - 1) + (post - 1) / (next - 1));
        System.out.println(result > n ? -1 : String.valueOf(result).charAt((int) ((post - 1) % (next - 1))) - '0');
    }
}
