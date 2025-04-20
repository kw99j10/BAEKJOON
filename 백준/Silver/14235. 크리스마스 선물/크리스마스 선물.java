import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 14235 크리스마스 선물
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.poll());
                }
                sb.append("\n");
            } else {
                for (int j = 0; j < num; j++) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.print(sb);
    }
}