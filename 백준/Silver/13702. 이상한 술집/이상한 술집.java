import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13702 이상한 술집
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long max = 0L;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);

        }

        long l = 1, r = max;
        while (l <= r) {
            long mid = (l + r) / 2;

            long count = 0L;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }
            if (k > count) {
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(r);
    }
}
