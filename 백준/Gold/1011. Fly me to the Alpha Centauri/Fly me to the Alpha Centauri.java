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
            int count = 0; // 움직임(-1 고려 x)
            int answer = 0;
            while (distance > 0) {
                count++;
                answer++;
                distance -= count;

                if (distance > 0) {
                    distance -= count;
                    answer++; // 2광년 이동 조건
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}