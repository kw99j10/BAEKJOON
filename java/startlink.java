import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14889 스타트와 링크
public class P14889 {
    static int n;
    static int[][] s;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n]; //능력치
        visit = new boolean[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }

    static void comb(int start, int count) {
        if (count == n / 2) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i] && visit[j]) {
                        sum += s[i][j];
                    }
                    else if (!visit[i] && !visit[j]) {
                        sum -= s[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sum));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}
