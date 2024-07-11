import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 6198 옥상 정원 꾸미기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();

        long sum = 0; //가능한 수는 int형을 넘을 수 있음
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            st.push(arr[i]);
            sum += st.size() - 1;
        }
        System.out.println(sum);
    }
}