import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5525 IOIOI
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Pn
        int m = Integer.parseInt(br.readLine()); // 문자열 길이
        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i <= m - (2 * n + 1); i++) {
            if (s.charAt(i) == 'I') {
                int tmp = 0;
                while (m > i + 2 && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                    tmp++;
                    i += 2;
                    if (tmp == n) {
                        tmp--; // Pn을 발견
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}