import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1935 후외 표기식2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                st.push((double) num[s.charAt(i) - 'A']);
            }else{
                Double fs = st.pop();
                Double sc = st.pop();

                // 연산자 처리
                if (s.charAt(i) == '+') {
                    st.push(sc + fs);
                } else if (s.charAt(i) == '-') {
                    st.push(sc - fs);
                }else if (s.charAt(i) == '*') {
                    st.push(sc * fs);
                }else if (s.charAt(i) == '/') {
                    st.push(sc / fs);
                }
            }
        }
        System.out.printf("%.2f", st.peek());
    }
}