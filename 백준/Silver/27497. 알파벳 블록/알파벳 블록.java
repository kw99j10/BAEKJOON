import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

// 27497 알파벳 블록
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Stack<Integer> num = new Stack<>(); // 버튼의 정보를 저장
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int button = Integer.parseInt(st.nextToken());
            if (button == 1 || button == 2) {
                String block = st.nextToken();
                if (button == 1) {
                    queue.addLast(block);
                    num.push(1);
                } else {
                    queue.addFirst(block);
                    num.push(2);
                }
            } else {
                if (!queue.isEmpty()) {
                    if (num.pop() == 1) {
                        queue.removeLast();
                    } else {
                        queue.removeFirst();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String list : queue) {
            sb.append(list);
        }
        System.out.println(queue.isEmpty() ? 0 : sb);
    }
}