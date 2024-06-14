import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2504 괄호의 값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> st = new Stack<>();

        long tmp = 1; //부분 괄호열 값 계산
        long sum = 0; //총 괄호열 값 계산
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(c);
                tmp *= 2;
            } else if (c == '[') {
                st.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    sum = 0;
                    break;
                } else {
                    if (s.charAt(i - 1) == '(') {
                        sum += tmp;
                    }
                    st.pop();
                    tmp /= 2;
                }
            } else {
                if (st.isEmpty() || st.peek() != '[') {
                    sum = 0;
                    break;
                } else {
                    if (s.charAt(i - 1) == '[') {
                        sum += tmp;
                    }
                    st.pop();
                    tmp /= 3;
                }
            }
        }
        if (!st.isEmpty()) {
            sum = 0; //올바르지 못한 괄호열
        }
        System.out.println(sum);
    }
}