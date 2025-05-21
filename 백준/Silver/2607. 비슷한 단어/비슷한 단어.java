import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2607 비슷한 단어
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A'] += 1;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] tmp = new int[26];
            System.arraycopy(alpha, 0, tmp, 0, 26);

            String t = br.readLine();

            for (int j = 0; j < t.length(); j++) {
                tmp[t.charAt(j) - 'A'] -= 1;
            }

            // 더 많은 글자 수
            int p = 0;
            int m = 0;
            for (int j = 0; j < 26; j++) {
                if (tmp[j] > 0) {
                    m += tmp[j];
                } else {
                    p -= tmp[j];
                }
            }

            if ((p == 0 && m == 0) || (p == 1 && m == 1) ||
                    (p == 0 && m == 1) || (p == 1 && m == 0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}