import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//카드 합체 놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = m;
        long total = 0;
        while (cnt != 0) {

            Arrays.sort(arr);
            long a = arr[0];
            long b = arr[1];

            long sum = a + b;
            arr[0] = sum;
            arr[1] = sum;
            cnt--;
        }

        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        System.out.println(total);
    }
}