import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4375 - 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String n;
        long num = 0L;
        while ((n = br.readLine()) != null && !n.isEmpty()) {
            int k = Integer.parseInt(n);
            for (int i = 1; ; i++) {
                num = num * 10 + 1;
                num %= k;
                if (num == 0) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}