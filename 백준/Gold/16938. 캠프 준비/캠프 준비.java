import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16938 캠프 준비
public class Main {
    static int n, l, r, x, count;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        comb(0, 0);
        System.out.println(count);
    }

    static void comb(int idx, int cnt) {
        if (idx == n) {
            if (cnt >= 2) {
                int sum = 0;
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int i = 0; i < n; i++) {
                    if (visit[i]) {
                        sum += arr[i];
                        min = Math.min(min, arr[i]);
                        max = Math.max(max, arr[i]);
                    }
                }
                if (sum >= l && sum <= r && max - min >= x) {
                    count++;
                }
            }
            return;
        }

        visit[idx] = true;
        comb(idx + 1, cnt + 1);
        visit[idx] = false;
        comb(idx + 1, cnt);
    }
}
