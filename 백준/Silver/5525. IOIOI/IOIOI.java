import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5525 IOIOI
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //Pn
        int m = Integer.parseInt(br.readLine()); // 문자열 길이
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * n + 1; i++) {
            if (i % 2 == 0) {
                sb.append("I");
            }else{
                sb.append("O");
            }
        }

        int cnt = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <= m - sb.length(); i++) {
            for (int j = i; j < i + sb.length(); j++) {
                sb2.append(s.charAt(j));
            }
            if (sb.toString().contentEquals(sb2)) {
                cnt++; // 해당 문자열이 있다면 count
            }else{
                sb2.setLength(0); // 다르다면 sb 초기화
            }
        }
        System.out.println(cnt);
    }
}