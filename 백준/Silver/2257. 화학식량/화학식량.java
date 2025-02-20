import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2257 화학식량
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 열린 괄호
            if (c == '(') {
                st.push(length);
                length = 0;
            }

            // 닫힌 괄호
            else if (c == ')') {
                if (s.length() > i + 1 && Character.isDigit(s.charAt(i + 1))) {
                    length *= (s.charAt(i + 1) - '0');
                }
                length += st.pop();
            }

            // 원소 기호
            else if (c == 'H' || c == 'O' || c == 'C') {
                if (c == 'H') {
                    if (s.length() > i + 1 && Character.isDigit(s.charAt(i + 1))) {
                        length += (s.charAt(i + 1) - '0');
                    } else {
                        length += 1;
                    }
                } else if (c == 'C') {
                    if (s.length() > i + 1 && Character.isDigit(s.charAt(i + 1))) {
                        length += 12 * (s.charAt(i + 1) - '0');
                    } else {
                        length += 12;
                    }
                } else {
                    if (s.length() > i + 1 && Character.isDigit(s.charAt(i + 1))) {
                        length += 16 * (s.charAt(i + 1) - '0');
                    } else {
                        length += 16;
                    }
                }
            }
        }
        System.out.println(length);
    }
}