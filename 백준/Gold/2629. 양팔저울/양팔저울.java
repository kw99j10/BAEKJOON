import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2629 양팔저울
public class Main {
    static int[] chu;
    static boolean[] sum; // 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 추의 개수
        chu = new int[n + 1];
        sum = new boolean[500 * n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            chu[i] = Integer.parseInt(st.nextToken());
        }

        isPossibleCount(); // 추로 만들 수 있는 무게의 경우의 수

        int m = Integer.parseInt(br.readLine()); // 구슬의 개수
        int[] gusul = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            gusul[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            if (500 * n >= gusul[i] && sum[gusul[i]]) {
                sb.append("Y").append(" ");
            } else {
                sb.append("N").append(" ");
            }
        }
        System.out.print(sb);
    }

    static void isPossibleCount() {
        sum[0] = true;
        for (int weight : chu) {
            boolean[] tmp = sum.clone();
            for (int i = 0; i < sum.length; i++) {
                if (sum[i] && sum.length > weight + i) {
                    tmp[weight + i] = true;
                    tmp[Math.abs(weight - i)] = true;
                }
            }
            sum = tmp;
        }
    }
}
