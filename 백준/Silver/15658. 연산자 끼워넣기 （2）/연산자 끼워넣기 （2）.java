import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15658 연산자 끼워넣기 (2)
public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] opt = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opt[i] = Integer.parseInt(st.nextToken());
        }
        num(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void num(int idx, int sum) {
        if (idx == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opt[i] > 0) {
                opt[i]--;
                if (i == 0) {
                    num(idx + 1, sum + arr[idx + 1]);
                } else if (i == 1) {
                    num(idx + 1, sum - arr[idx + 1]);
                }else if (i == 2) {
                    num(idx + 1, sum * arr[idx + 1]);
                }else{
                    num(idx + 1, sum / arr[idx + 1]);
                }
                opt[i]++;
            }
        }
    }
}