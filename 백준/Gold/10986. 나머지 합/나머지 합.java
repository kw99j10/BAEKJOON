import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10986 나머지 합
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1]; // 누적합

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        long[] count = new long[m]; // 같은 나머지를 가지는 개수
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (sum[i] % m == 0) {
                cnt++;
            }
            count[(int) (sum[i] % m)]++;
        }

        for (int i = 0; i < m; i++) {
            if (count[i] != 0) {
                cnt += (count[i] * (count[i] - 1) / 2); // 나머지 누적합 조합
            }
        }
        System.out.println(cnt);
    }
}