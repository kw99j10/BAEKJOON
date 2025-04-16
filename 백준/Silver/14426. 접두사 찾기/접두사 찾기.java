import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14426 접두사 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        // 기존 탐색: startsWith 시간 초과 문제 (X) => 이분 탐색
        int count = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid].startsWith(s)) {
                    count++;
                    break;
                }

                if (arr[mid].compareTo(s) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(count);
    }
}