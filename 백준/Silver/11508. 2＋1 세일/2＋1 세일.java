import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//2+1 세일
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int sum = 0;
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (idx % 3 == 2) {
                idx = 0;
                continue;
            }
            sum += arr[i];
            idx++;
        }
        System.out.println(sum);
    }
}
