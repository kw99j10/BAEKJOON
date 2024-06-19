import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//3015 오아시스 재결합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> st = new Stack<>(); // 사람 인덱스, 볼 수 있는 쌍
        long count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] current = new int[]{num, 1};

            while (!st.isEmpty() && num >= st.peek()[0]) {
                int[] before = st.pop();
                count += before[1];

                if (before[0] == current[0]) {
                    current[1] += before[1]; //키가 같을 경우
                }
            }
            if (!st.isEmpty()) {
                count++;
            }
            st.push(current);
        }
        System.out.print(count);
    }
}