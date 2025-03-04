import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17266 어두운 굴다리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = 0;
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = Integer.parseInt(st.nextToken()); // 가로등 위치

            if (m == 1) {
                System.out.println(Math.max(x[i], n - x[i]));
                return;
            }

            if (i == 0) {
                h = Math.max(h, x[i]);
                continue;
            }
            h = Math.max((x[i] - x[i - 1]) / 2 + (x[i] - x[i - 1]) % 2, h);
            
            if (i == m - 1) {
                h = Math.max(n - x[i], h);
            }
        }
        System.out.println(h);
    }
}