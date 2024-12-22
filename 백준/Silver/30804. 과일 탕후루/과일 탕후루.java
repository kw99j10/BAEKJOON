import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 30804 과일 탕후루
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] fruit = new int[10];
        int count = 0; // 과일의 종류
        int max = 0; // 과일의 개수
        int left = 0;
        int right = 0;

        while (right < n) {
            if (fruit[arr[right]] == 0) {
                count++;
            }
            fruit[arr[right++]]++;

            while (count > 2) {
                if (fruit[arr[left]] == 1) {
                    count--; // 두 종류 이상
                }
                fruit[arr[left++]]--;
            }
            max = Math.max(max, right - left);
        }
        System.out.println(max);
    }
}
