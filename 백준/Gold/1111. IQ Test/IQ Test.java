import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// IQ Test
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 2 && arr[0] == arr[1]) {
            System.out.println(arr[0]);
            return;
        }
        else if (n == 1 || n == 2) {
            System.out.println("A");
            return;
        }
        for (int i = -200; i <= 200; i++) {
            int tmp = arr[1] - arr[0] * i;

            int idx = 2;
            while (tmp == arr[idx] - arr[idx - 1] * i) {
                if (idx == n - 1) {
                    System.out.println(arr[n - 1] * i + tmp);
                    return;
                }
                idx++;
            }
        }
        System.out.println("B");
    }
}