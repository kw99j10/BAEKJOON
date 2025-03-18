import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 25916 싫은데요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 부피

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        long sum = 0L, max = 0L;
        while (r < n) {
            sum += arr[r++];

            while (sum > m) {
                sum -= arr[l++];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}