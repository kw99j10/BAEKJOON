import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20922 겹치는 건 싫어
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] count = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        int max = 0, cnt = 0;
        while (r < n) {
            if (k > count[arr[r]]) {
                count[arr[r++]]++;
                cnt++;
            } else {
                count[arr[l++]]--;
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}