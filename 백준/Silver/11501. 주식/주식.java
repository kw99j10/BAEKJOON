import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] stock = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (stock[i] > max) {
                    max = stock[i];
                }
                sum += max - stock[i];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}