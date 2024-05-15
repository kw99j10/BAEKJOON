import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        while (left <= n - 1 && right <= n - 1) {
            int sum = arr[right] - arr[left];
            if (sum >= m) {
                min = Math.min(min, sum);
                left += 1;
            } else {
                right += 1;
            }
        }
        System.out.println(min);
    }
}