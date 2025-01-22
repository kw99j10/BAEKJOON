import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1011 Fly me to the Alpha Centauri
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int min = (int) Math.sqrt(y - x);
            int tmp = min * (min + 1);

            int answer; // 최소 2*k-1, 2*k, 2*k+1 광년씩 이동 가능
            if (min == Math.sqrt(distance)) {
                answer = 2 * min - 1;
            } else if (tmp >= distance) {
                answer = 2 * min;
            } else {
                answer = 2 * min + 1;
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}