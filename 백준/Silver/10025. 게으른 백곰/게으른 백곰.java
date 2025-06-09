import java.io.*;
import java.util.*;

// 10025 게으른 백곰
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int size = 1000001;
        int[] x = new int[size];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gi = Integer.parseInt(st.nextToken());
            int xi = Integer.parseInt(st.nextToken());
            x[xi] = gi;
        }

        long[] sum = new long[size];
        sum[0] = x[0];
        for (int i = 1; i < size; i++) {
            sum[i] = sum[i - 1] + x[i];
        }

        long max = 0L;
        for (int i = 0; i < size; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(size - 1, i + k);
            long total = sum[right] - (left > 0 ? sum[left - 1] : 0);
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}