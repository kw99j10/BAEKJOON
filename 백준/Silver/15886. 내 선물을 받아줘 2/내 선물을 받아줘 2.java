import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15886 내 선물을 받아줘 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            String tmp = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
            if (tmp.equals("EW")) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}