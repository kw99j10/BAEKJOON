import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21921 블로그
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        long max = 0L;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);
        for (int i = 1; i < n - x + 1; i++) {
            sum += arr[i + x - 1];
            sum -= arr[i - 1];
            max = Math.max(max, sum);
        }

        int cnt = 0;
        sum = 0L;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        cnt = sum == max ? cnt + 1 : cnt;
        for (int i = 1; i < n - x + 1; i++) {
            sum += arr[i + x - 1];
            sum -= arr[i - 1];
            cnt = sum == max ? cnt + 1 : cnt;
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
