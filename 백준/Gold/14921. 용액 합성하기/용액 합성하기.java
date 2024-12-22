import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14921 용액 합성하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int b = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        while (left < right) {

            int sum = arr[left] + arr[right];

            if (Math.abs(b) > Math.abs(sum)) {
                b = sum;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(b);
    }
}
