import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 28066 타노스는 요세푸스가 밉다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            if (queue.size() >= k) {
                int tmp = queue.removeFirst();
                queue.addLast(tmp);
                int count = 0;
                while (count != k - 1) {
                    queue.removeFirst();
                    count++;
                }
            } else {
                while (queue.size() != 1) {
                    queue.removeLast();
                }
            }
        }
        System.out.println(queue.peek());
    }
}