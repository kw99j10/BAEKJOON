import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2792 보석 상자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int l = 1;
        int r = 0;
        int[] color = new int[m];
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, color[i]);
        }

        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;

            int count = 0;
            for (int i = 0; i < m; i++) {
                count += (color[i] + mid - 1) / mid; //3,3,4
            }

            if (n >= count) {
                r = mid - 1;
                min = Math.min(min, mid);
            } else {
                l = mid + 1;
            }
        }
        System.out.println(min);
    }
}