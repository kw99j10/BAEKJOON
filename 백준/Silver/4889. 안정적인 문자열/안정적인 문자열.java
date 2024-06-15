import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 4889 안정적인 문자열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.contains("-")) {
                break; //종료 조건
            }
            Stack<Character> stack = new Stack<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push(c);
                }else{
                    if (stack.isEmpty()) {
                        stack.push('{');
                        count++;
                    }else{
                        stack.pop();
                    }
                }
            }
            count += stack.size() / 2;
            sb.append(idx++).append(". ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}