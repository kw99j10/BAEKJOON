import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2631 줄세우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = 0; // min의 값은 LIS 이므로 이를 제외한 아이들을 옮겨야함
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && line[j] + 1 > line[i]) {
                    line[i] = line[j] + 1;
                }
            }
            min = Math.max(min, line[i]);
        }
        System.out.println(n - min);
    }
}