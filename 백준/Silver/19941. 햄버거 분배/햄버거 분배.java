import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19941 햄버거 분배
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int[] arr = new int[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {

            // 사람 -> 햄버거 분배
            if (s.charAt(i) == 'P') {
                for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if (s.charAt(j) == 'H' && arr[j] == 0) {
                        arr[j] = 1;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}