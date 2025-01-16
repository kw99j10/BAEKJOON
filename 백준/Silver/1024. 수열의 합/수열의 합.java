import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1024 수열의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        if (n == 1 && l == 2) {
            System.out.println(0 + " " + 1); // 예외 케이스
            return;
        }

        if (n + 1 < l) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        boolean isPossible = true;
        while (true) {
            int num = (n - l * (l - 1) / 2) / l;

            // 만들 수 없거나 길이가 100을 넘어가는 경우
            if (num < 0 || (n - l * (l - 1) / 2) < 0 || l > 100) {
                isPossible = false;
                break;
            }

            long sum = 0L;
            for (int i = 0; i < l; i++) {
                sum += (num + i);
            }
            if (sum == n) {
                for (int i = 0; i < l; i++) {
                    sb.append(num + i).append(" ");
                }
                break;
            }
            l++;
        }
        System.out.println(isPossible ? sb : -1);
    }
}