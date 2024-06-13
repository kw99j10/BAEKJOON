import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9324 진짜 메시지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean isTrue = true;

            int[] alpha = new int[26];
            for (int j = 0; j < s.length() - 1; j++) {
                int k = s.charAt(j) - 65;
                alpha[k]++;

                if (alpha[k] % 3 == 0) {
                    if (s.charAt(j) != s.charAt(j + 1)) {
                        isTrue = false;
                        break;
                    }
                    j++;
                }
            }
            if (isTrue) {
                alpha[s.charAt(s.length() - 1) - 65]++;
                if ( alpha[s.charAt(s.length() - 1) - 65] % 3 == 0) {
                    isTrue = false;
                }
            }
            String tmp = isTrue ? "OK" : "FAKE";
            sb.append(tmp).append("\n");
        }
        System.out.print(sb);
    }
}