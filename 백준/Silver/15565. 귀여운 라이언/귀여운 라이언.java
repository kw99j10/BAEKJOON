import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15565 귀여운 라이언
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                count++;
            }
        }

        if (k > count) {
            System.out.println(-1);
            return;
        }

        int l = 0, r = 0, min = Integer.MAX_VALUE;
        count = 0;
        while (r < n) {
            if (arr[r] == 1) {
                count++;
            }
            r++;

            while (count >= k) {
                min = Math.min(min, r - l);
                if (arr[l++] == 1) {
                    count--;
                }
            }
        }
        System.out.println(min);
    }
}
