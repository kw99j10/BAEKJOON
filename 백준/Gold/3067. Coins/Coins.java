import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3067 Coins
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine()); // 만들어야 할 금액

            int[] coin = new int[10001];
            coin[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = arr[i]; j <= m; j++) {
                    coin[j] += coin[j - arr[i]];
                }
            }
            sb.append(coin[m]).append("\n");
        }
        System.out.print(sb);
    }
}
