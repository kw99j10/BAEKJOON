import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16938 캠프 준비
public class Main {
    static int n, l, r, x, count;
    static int[] subject;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 문제 수
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()); // 문제 난이도 차

        subject = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            subject[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(count);
    }

    static void comb(int idx, int cnt, int sum, int easy, int hard) {

        if (cnt >= 2 && (sum >= l && sum <= r) && hard - easy >= x) {
            count++;
        }

        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(i, cnt + 1, sum + subject[i], Math.min(easy, subject[i]), Math.max(hard, subject[i]));
                visit[i] = false;
            }
        }
    }
}