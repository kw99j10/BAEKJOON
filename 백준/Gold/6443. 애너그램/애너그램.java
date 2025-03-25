import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 6443 애너그램
public class Main {
    static StringBuilder sb;
    static char[] s;
    static int[] alpha;
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s = br.readLine().toCharArray();
            Arrays.sort(s);

            sb = new StringBuilder();
            alpha = new int[26];
            result = new char[s.length];
            for (char c : s) {
                alpha[c - 97]++;
            }
            comb(0);
            ss.append(sb);
        }
        System.out.print(ss);
    }

    static void comb(int cnt) {
        if (cnt == s.length) {
            for (char c : result) {
                sb.append(c);
            }
            sb.append("\n");
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                result[cnt] = (char) ('a' + i);
                comb(cnt + 1);
                alpha[i]++;
            }
        }
    }
}