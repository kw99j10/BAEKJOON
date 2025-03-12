import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2661 좋은수열
public class Main {
    static int[] num = {1, 2, 3};
    static int[] result;
    static int n;
    static boolean isPossible = false;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        sb = new StringBuilder();
        perm(0);
        System.out.print(sb);
    }

    static void perm(int idx) {
        if (isPossible) {
            return;
        }

        if (idx == n) {
            for (int i = 0; i < n; i++) {
                sb.append(result[i]);
            }
            isPossible = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            result[idx] = num[i];
            if (goodPerm(idx)) {
                perm(idx + 1);
            }
        }
    }

    static boolean goodPerm(int idx) {
        for (int i = 1; i <= (idx + 1) / 2; i++) {
            boolean isPossible = false;

            for (int j = 0; j < i; j++) {
                if (result[idx - j] != result[idx - j - i]) {
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                return false;
            }
        }
        return true;
    }
}