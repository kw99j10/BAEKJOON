import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6603 로또
public class Main {
    static int k;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[k];
            result = new int[6];
            comb(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void comb(int idx, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            result[cnt] = arr[i];
            comb(i + 1, cnt + 1);
        }
    }
}