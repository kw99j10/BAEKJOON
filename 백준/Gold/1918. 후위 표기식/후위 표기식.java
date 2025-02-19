import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1918 후위 표기식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 피연산자는 출력함
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            }

            // 연산자
            else {
                // 비어있거나 열린 괄호
                if (st.isEmpty() || c == '(') {
                    st.push(c);
                }

                // 닫는 괄호는 여는 괄호가 나올 때까지
                else if (c == ')') {
                    while (!st.isEmpty()) {
                        if (st.peek() == '(') {
                            st.pop();
                            break;
                        }
                        sb.append(st.pop());
                    }
                }

                // 우선 순위 높은 연산자
                else if (c == '*' || c == '/') {
                    if (st.peek() == '*' || st.peek() == '/') {
                        sb.append(st.pop());
                    }
                    st.push(c);
                }

                // 우선 순위 낮은 연산자
                else if (c == '+' || c == '-') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        sb.append(st.pop());
                    }
                    st.push(c);
                }
            }
        }

        // 남은 피연산자
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.print(sb);
    }
}