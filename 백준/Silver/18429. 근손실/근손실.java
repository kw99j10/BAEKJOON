import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18429 근손실
public class Main {
    static int[] tool;
    static boolean[] visit;
    static int n, k, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tool = new int[n];
        for (int i = 0; i < n; i++) {
            tool[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n];
        muscle(0, 500); //경우의 수
        System.out.println(count);
    }

    static void muscle(int idx, int loss) {
        if (idx == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i] && loss + tool[i] - k >= 500) {
                visit[i] = true;
                muscle(idx + 1, loss + tool[i] - k);
                visit[i] = false;
            }
        }
    }
}