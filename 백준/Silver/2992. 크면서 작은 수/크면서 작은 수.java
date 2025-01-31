import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2992 크면서 작은 수
public class Main {
    static String x;
    static int answer = Integer.MAX_VALUE;
    static char[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        x = br.readLine();
        result = x.toCharArray();

        visit = new boolean[x.length()];
        perm(0, new StringBuilder());
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    static void perm(int idx, StringBuilder tmp) {
        if (idx == x.length()) {
            int num = Integer.parseInt(tmp.toString());
            if (num > Integer.parseInt(x)) {
                answer = Math.min(answer, num);
            }
            return;
        }

        for (int i = 0; i < x.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                tmp.append(result[i]);
                perm(idx + 1, tmp);
                tmp.deleteCharAt(tmp.length() - 1);
                visit[i] = false;
            }
        }
    }
}