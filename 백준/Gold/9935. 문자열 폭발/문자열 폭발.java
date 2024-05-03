import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//문자열 폭발
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= boom.length()) {
                boolean isBoom = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.print(sb);
        }
    }
}
