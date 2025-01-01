import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1769 3의 배수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        String tmp = s;
        while (tmp.length() != 1) {
            int sum = 0;
            for (int i = 0; i < tmp.length(); i++) {
                sum += tmp.charAt(i) - '0';
            }
            tmp = String.valueOf(sum);
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(tmp) % 3 == 0 ? "YES" : "NO");
    }
}
