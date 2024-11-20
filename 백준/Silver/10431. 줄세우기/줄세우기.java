import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 10431 줄세우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int count = 0;
            int[] arr = new int[20];
            arr[0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if (arr[k] > arr[j]) {
                        int tmp = arr[k];
                        arr[k] = arr[j];
                        arr[j] = tmp;
                        count++;
                    }
                }
            }
            sb.append(num).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}