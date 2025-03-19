import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2877 4와 7
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 4, 7 을 0, 1 이진수 형태로 치환
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            sb.append(k % 2 == 0 ? 7 : 4);
            k = (k - 1) / 2;
        }
        System.out.print(sb.reverse());
    }
}
