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

        int[] arr = new int[n]; //주어진 수열
        int[] count = new int[100001]; //같은 정수의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cnt = 0;
        int left = 0;
        int right = 0;

        while (left <= right && right < n) {
            if (count[arr[right]] >= k) {
                count[arr[left]]--;
                left++;
                cnt--;
            } else {
                count[arr[right]]++;
                right++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}