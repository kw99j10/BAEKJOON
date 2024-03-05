import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//옥상정원 꾸미기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0; //탐색 범위가 int를 넘어감
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            //현재 빌딩보다 높은 높이의 빌딩이 오면 스택에서 꺼냄
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            answer += stack.size(); //스택의 크기만큼 확인할 수 있었음
            stack.push(arr[i]);
        }

        System.out.println(answer);
    }
}
