import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10973 이전 순열
public class Main {
    static int n;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        if (perm()) {
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
        } else {
            System.out.println(-1);

        }
    }

    static boolean perm() {
        int i = n - 1;
        int j = n - 1;

        // 내림차순이 아닌 idx 찾기
        while (i > 0 && result[i - 1] <= result[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }


        while (result[j] >= result[i - 1]) {
            j -= 1;
        }

        int tmp = result[i - 1];
        result[i - 1] = result[j];
        result[j] = tmp;

        j = n - 1;
        while (i < j) {
            tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}