import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16943 숫자 재배치
public class Main {
    static int[] a;
    static int b, max = -1;
    static int[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String ta = st.nextToken();
        b = Integer.parseInt(st.nextToken());

        a = new int[10];
        for (int i = 0; i < ta.length(); i++) {
            a[ta.charAt(i) - '0']++;
        }
        c = new int[ta.length()];
        perm(0);
        System.out.println(max);
    }

    static void perm(int idx) {
        if (idx == c.length) {

            boolean isPossible = true;
            StringBuilder sb = new StringBuilder();
            for (int j : c) {
                sb.append(j);
            }
            if (sb.toString().startsWith("0")) {
                isPossible = false;
            }

            if (isPossible) {
                int num = Integer.parseInt(sb.toString());
                if (num < b) {
                    max = Math.max(max, num);
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (a[i] > 0) {
                a[i] -= 1;
                c[idx] = i;
                perm(idx + 1);
                a[i] += 1;
            }
        }
    }
}