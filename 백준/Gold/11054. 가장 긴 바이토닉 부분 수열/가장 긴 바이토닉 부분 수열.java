import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11054 가장 긴 바이토닉 부분 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[n + 1]; // 증가 수열
        int[] down = new int[n + 1]; // 감소 수열

        for (int i = 1; i <= n; i++) {
            up[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (arr[i] > arr[j] && up[j] + 1 > up[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            down[i] = 1;
            for (int j = n; j >= i; j--) {
                if (arr[i] > arr[j] && down[j] + 1 > down[i]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, up[i] + down[i]);
        }
        System.out.println(max - 1);
    }
}