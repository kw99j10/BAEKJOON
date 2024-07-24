import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] num = new long[101];
        num[1] = num[2] = num[3] = 1;
        for (int i = 4; i <= 100; i++) {
            num[i] = num[i - 2] + num[i - 3];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(num[k]).append("\n");
        }
        System.out.print(sb);
    }
}