import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9024 두 수의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            int min = Integer.MAX_VALUE;
            int answer = 0; //조합의 수

            // 이분 탐색
            while (left < right) {

                int sum = arr[left] + arr[right];
                if (min > Math.abs(k - sum)) {
                    min = Math.abs(k - sum);
                    answer = 1;
                } else if (min == Math.abs(k - sum)) {
                    answer++;
                }

                if (sum >= k) {
                    right--;
                } else{
                    left++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}