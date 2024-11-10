import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1783 병든 나이트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 1 || m == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(Math.min((m + 1) / 2, 4)); // 2,3번만 가능 => 이동 제약 (첫 칸: +1)
        } else if (n >= 3 && m <= 6) {
            System.out.println(Math.min(4, m)); // 오른쪽 이동 횟수만 고려
        } else {
            System.out.println(m - 2); // 그외 모든 경우 가능
        }
    }
}