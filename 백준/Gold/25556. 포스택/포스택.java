import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 25556 포스택
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer>[] stack = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stack[i] = new Stack<>();
        }

        String pos = "YES";

        for (int i = 0; i < n; i++) {

            boolean isPossible = false;
            for (int j = 0; j < 4; j++) {
                if (stack[j].isEmpty() || arr[i] > stack[j].peek()) {
                    stack[j].push(arr[i]);
                    isPossible = true;
                    break;
                }
            }

            // 스택에 숫자를 넣을 수 없음
            if (!isPossible) {
                pos = "NO";
                break;
            }
        }
        System.out.println(pos);
    }
}