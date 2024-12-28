import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20159 동작 그만. 밑장 빼기냐?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] odd = new int[n / 2 + 1]; // 주는 경우
        int[] even = new int[n / 2 + 1]; // 받는 경우

        for (int i = 1; i <= n / 2; i++) {
            odd[i] = odd[i - 1] + Integer.parseInt(st.nextToken());
            even[i] = even[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = Math.max(odd[n / 2], even[n / 2]); // 밑장을 안 뺀 경우
        for (int i = 1; i <= n / 2; i++) {
            // 밑장을 빼서 나한테
            max = Math.max(max, even[n / 2] - even[i - 1] + odd[i - 1]);

            // 밑장을 빼서 상대한테
            max = Math.max(max, even[n / 2 - 1] - even[i - 1] + odd[i]);
        }
        System.out.println(max);
    }
}
