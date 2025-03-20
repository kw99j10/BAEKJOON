import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12847 꿀 아르바이트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        long max = 0L;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);

        for (int i = 1; i < n - m + 1; i++) {
            sum += arr[i + m - 1];
            sum -= arr[i - 1];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
