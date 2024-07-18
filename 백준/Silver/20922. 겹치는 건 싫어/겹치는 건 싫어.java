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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[200001]; // 나온 정수의 개수

        int max = 0; // 최장 연속 부분 수열 길이
        int cnt = 0; // 현재 수열 길이
        int left = 0;
        int right = 0;

        while (right < n) {
            count[arr[right]]++;
            cnt++;

            while (count[arr[right]] > k) {
                count[arr[left]]--;
                left++;
                cnt--;
            }

            max = Math.max(max, cnt);
            right++;
        }
        System.out.println(max);
    }
}