import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15904 UCPC는 무엇의 약자일까?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'U' || c == 'C' || c == 'P') {
                tmp += c;
            }
        }
        String answer = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c == 'U' && answer.length() == 0) {
                answer += c;
            }
            if (c == 'C' && answer.length() == 1) {
                answer += c;
            }
            if (c == 'P' && answer.length() == 2) {
                answer += c;
            }
            if (c == 'C' && answer.length() == 3) {
                answer += c;
            }
        }
        System.out.println(answer.equals("UCPC") ? "I love UCPC" : "I hate UCPC");
    }
}
