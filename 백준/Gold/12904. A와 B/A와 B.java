import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// A와 B
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()) {
            int idx = t.length() - 1;
            if (t.charAt(idx) == 'A') {
                t = t.substring(0, t.length() - 1); //문자열 뒤에 A를 제거
            } else if (t.charAt(idx) == 'B') {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString(); //문자열 뒤 B를 제거하고 뒤집음
            }
        }
        System.out.println(s.equals(t) ? 1 : 0);
    }
}