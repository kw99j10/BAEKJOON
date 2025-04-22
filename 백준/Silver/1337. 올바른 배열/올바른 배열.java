import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1337 올바른 배열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int count = 5;
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] - arr[left] > 4) {
                left++;
            }
            count = Math.min(count, 5 - (i - left + 1));
        }
        System.out.println(count);
    }
}