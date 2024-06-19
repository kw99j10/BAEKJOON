import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//15926 현욱은 괄호왕이야!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Stack<Integer> st = new Stack<>();
        
        //올바른 괄호 부분 문자열을 파악하기 위해 인덱스를 스텍에 넣음
        st.push(-1); // 초기값을 -1로 설정
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i); //부분 문자열이 올바르지 않아지는 지점
                } else {
                    max = Math.max(max, i - st.peek()); //최대 길이 갱신
                }
            }
        }
        System.out.print(max);
    }
}