import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6064 카잉 달력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken()); // <m:n> 마지막 해
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); // <x:y> 꼴

            boolean isPossible = false; // 유효한 해 여부
            for (int i = x; i <= m * n; i += m) {
                if ((i - y) % n == 0) {
                    isPossible = true;
                    sb.append(i); // 나머지 정리
                    break;
                }
            }
            if (!isPossible) {
                sb.append(-1);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}