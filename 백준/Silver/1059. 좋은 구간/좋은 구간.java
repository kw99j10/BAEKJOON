import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1059 좋은 구간
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = 0;
        int max = 0;
        int n = Integer.parseInt(br.readLine());

        // n이 S보다 작은 값의 경우
        if (arr[0] > n) {
            min = 1;
            max = arr[0] - 1;
        }
        // n이 집합 S 사이에 존재하는 경우
        else {
            for (int i = 0; i < l; i++) {
                if (arr[i] > n) {
                    min = arr[i - 1] + 1;
                    max = arr[i] - 1;
                    break;
                }
            }
        }

        int count = 0;
        for (int i = min; i <= n; i++) {
            for (int j = n; j <= max; j++) {
                if (i < j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}