import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 27496 발머의 피크 이론
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        long sum = arr[0];
        if (sum >= 129 && sum <= 138) {
            count++;
        }

        for (int i = 1; i < n; i++) {
            sum += arr[i];
            if (i >= l) {
                sum -= arr[i - l];
            }
            if (sum >= 129 && sum <= 138) {
                count++;
            }
        }
        System.out.println(count);
    }
}
