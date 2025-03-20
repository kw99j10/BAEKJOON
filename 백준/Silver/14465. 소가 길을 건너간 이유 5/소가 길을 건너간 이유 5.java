import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14465 소가 길을 건너간 이유 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < b; i++) {
            arr[Integer.parseInt(br.readLine())] = 1; // 부서진 신호등
        }

        long sum = 0L;
        for (int i = 1; i <= k; i++) {
            sum += arr[i];
        }

        long min = Integer.MAX_VALUE;
        for (int i = 2; i <= n - k + 1; i++) {
            sum += arr[i + k - 1];
            sum -= arr[i - 1];
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }
}
