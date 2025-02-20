import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 15815 천재 수학자 성필
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+') {
                st.push(st.pop() + st.pop());
            } else if (c == '-') {
                st.push(-(st.pop() - st.pop()));
            } else if (c == '*') {
                st.push(st.pop() * st.pop());
            } else if (c == '/') {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(c - '0');
            }
        }
        System.out.println(st.pop());
    }
}