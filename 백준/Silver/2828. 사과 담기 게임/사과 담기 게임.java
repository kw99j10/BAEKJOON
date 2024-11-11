import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2828 사과 담기 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int distance = 0;

        // 바구니가 차지하는 칸
        int start = 1;
        int end = m;
        int j = Integer.parseInt(br.readLine());
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple > end) {
                distance += apple - end;
                start += apple - end;
                end = apple;
            } else if (start > apple) {
                distance += start - apple;
                end -= start - apple;
                start = apple;
            }
        }
        System.out.println(distance);
    }
}