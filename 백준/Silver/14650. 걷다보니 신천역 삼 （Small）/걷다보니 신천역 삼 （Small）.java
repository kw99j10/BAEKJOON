import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 14650 걷다보니 신천역 삼
public class Main {
    static int[] num = {0, 1, 2};
    static int[] result;
    static boolean[] visit;
    static int n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        visit = new boolean[3];
        perm(0);
        System.out.print(count);
    }

    static void perm(int idx) {
        if (idx == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(result[i]);
            }
            int tmp = Integer.parseInt(sb.toString());
            if (tmp % 3 == 0) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (idx == 0 && num[i] == 0) {
                continue; // 맨 앞은 0이 오면 안됨
            }
            result[idx] = num[i];
            perm(idx + 1);
        }
    }
}