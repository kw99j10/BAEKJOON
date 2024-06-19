import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

//3015 오아시스 재결합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> h = new HashMap<>(); // 서로 볼 수 있는 쌍
        long count = 0; //쌍의 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (!h.containsKey(num)) {
                h.put(num, 0);
            }

            while (!stack.isEmpty()) {
                if (stack.peek() > num) {
                    count++; // 앞 사람 > 현재 사람: 앞 사람이 볼 수 있음 => +1
                    break;
                } else if (stack.peek() == num) {
                    count += h.get(num) + 1; // 앞사람 = 현재 사람: 서로 볼 수 있음 => +1
                    h.put(num, h.getOrDefault(num, 0) + 1);
                    stack.pop();
                } else {
                    count++; // 현재 사람 > 앞 사람: 앞 사람은 그 뒤를 더이상 볼 수 없음 => pop && +1
                    Integer before = stack.pop();
                    if (h.get(before) != 0) {
                        count += h.get(before); // 이전의 누적 쌍을 더함
                        h.put(before, 0);
                    }
                }
            }
            stack.push(num);
        }
        System.out.print(count);
    }
}