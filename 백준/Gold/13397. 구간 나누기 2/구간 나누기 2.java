import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13397 구간 나누기 2
public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int l = 0, r = max - min;
        while (l < r) {
            int mid = (l + r) / 2;

            // 중앙값에 대하여 구간 체크
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

    static boolean check(int mid) {
        int count = 1;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > mid) {
                count++;
                min = arr[i];
                max = arr[i];
            }
        }
        return count <= m;
    }
}
