import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1874 스택 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            while (num <= tmp) {
                st.push(num++);
                sb.append('+').append("\n");
            }


            if (tmp == st.peek()) {
                st.pop();
                sb.append("-").append("\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb);
    }
}