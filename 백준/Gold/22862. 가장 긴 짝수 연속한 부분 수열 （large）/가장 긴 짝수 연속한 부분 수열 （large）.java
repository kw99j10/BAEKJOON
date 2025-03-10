import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22862 가장 긴 짝수 연속한 부분 수열 (large)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int even = 0;
        int odd = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (arr[right] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            // k번까지만 삭제 가능
            while (odd > k) {
                if (arr[left] % 2 == 0) {
                    even--;
                } else {
                    odd--;
                }
                left++;
            }
            right++;
            max = Math.max(max, even);
        }
        System.out.println(max);
    }
}