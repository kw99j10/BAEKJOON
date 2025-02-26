import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 9375 패션왕 신해빈
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken(); // 이름
                String category = st.nextToken(); // 종류
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int count = 1;
            for (Integer value : map.values()) {
                count *= value + 1;
            }
            sb.append(count - 1).append("\n"); // 알몸인 경우 제외
        }
        System.out.print(sb);
    }
}