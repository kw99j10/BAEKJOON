import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1105 팔
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); //l<=r

        int cnt = 0;

        String L = String.valueOf(l);
        String R = String.valueOf(r);

        // 자릿수가 다르면 8이 적게 들어있는 수는 0개
        if (L.length() == R.length()) {
            for (int i = 0; i < R.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) {
                    break;
                }
                if (L.charAt(i) == R.charAt(i) && R.charAt(i) == '8') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}