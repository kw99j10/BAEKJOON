import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1758 알바생 강호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max = 0;
        int rank = 0;
        for (int i = n; i >= 1; i--) {
            int sum = arr[i] - (++rank - 1);
            if (sum > 0) {
                max += sum;
            }
        }
        System.out.println(max);
    }
}