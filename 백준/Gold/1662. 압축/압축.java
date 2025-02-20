import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1662 압축
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = 0;
        Stack<Integer> st = new Stack<>(); // 일반 문자열의 길이
        Stack<Integer> k = new Stack<>(); // 압축한 문자열의 길이
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 열린 괄호
            if (c == '(') {
                st.push(length); // 이전이 압축값
                length = 0;
            }

            // 다음 괄호가 열린 괄호
            else if (s.length() > i + 1 && s.charAt(i + 1) == '(') {
                k.push(c - '0');
            }

            // 닫힌 괄호
            else if (c == ')') {
                int tmp = length;
                length = k.pop() * tmp + st.pop();
            }

            // 그냥 숫자인 경우
            else {
                length++;
            }
        }
        System.out.println(length);
    }
}