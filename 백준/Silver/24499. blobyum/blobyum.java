import java.io.*;
import java.util.*;

// 24499 blobyum
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long sum = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0L;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);

        for (int i = 1; i < n; i++) {
            sum += arr[(i + k - 1) % n];
            sum -= arr[i - 1];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}