import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22857 가장 긴 짝수 연속한 부분 수열 (small)
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
        int remove = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            // 짝수일 때
            if (arr[right] % 2 == 0) {
                even++;
                max = Math.max(max, even);
            }

            // 홀수일 때
            else {
                if (k > remove) {
                    remove++;
                } else {
                    while (right >= left && arr[left] % 2 == 0) {
                        even--;
                        left++;
                    }
                    left++;
                }
            }
            right++;
        }
        System.out.println(max);
    }
}