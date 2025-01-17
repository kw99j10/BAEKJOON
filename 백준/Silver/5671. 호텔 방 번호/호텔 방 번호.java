import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5671 호텔 방 번호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = n; i <= m; i++) {
                int[] num = new int[10];

                String tmp = String.valueOf(i);
                for (int j = 0; j < tmp.length(); j++) {
                    int k = tmp.charAt(j) - '0';
                    num[k] += 1;
                }

                boolean isPossible = true;
                for (int j = 0; j < 10; j++) {
                    if (num[j] > 1) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}