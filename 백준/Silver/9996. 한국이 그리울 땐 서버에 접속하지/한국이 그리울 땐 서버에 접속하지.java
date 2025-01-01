import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9996 한국이 그리울 땐 서버에 접속하지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int idx = s.indexOf('*');
        String t1 = s.substring(0, idx);
        String t2 = s.substring(idx + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (t1.length() + t2.length() > tmp.length()) {
                sb.append("NE").append("\n");
            } else if (t1.charAt(0) == tmp.charAt(0) &&
                    t2.charAt(t2.length() - 1) == tmp.charAt(tmp.length() - 1) &&
                    tmp.contains(t1) && tmp.contains(t2)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
