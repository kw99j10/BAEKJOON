import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 1655 가운데를 말해요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (min.isEmpty()) {
                min.add(num);
            } else {
                if (min.peek() > num) {
                    max.add(min.poll());
                    min.add(num);
                } else {
                    max.add(num);
                }
            }

            // 최솟값 큐의 가장 큰 값과 최댓값 큐의 가장 작은 값을 비교

            if (!max.isEmpty() && num > max.peek()) {
                if (max.size() > min.size()) {
                    min.add(max.poll());
                }
                max.add(num);
            }

            else if (!max.isEmpty() && !min.isEmpty() && num >= min.peek() && num <= max.peek()) {
                if (max.size() > min.size()) {
                    min.add(num);
                } else {
                    max.add(num);
                }
            }

            else {
                if (min.size() > max.size()) {
                    max.add(min.poll());
                }
                min.add(num);
            }
            sb.append(min.peek()).append("\n");
        }
        System.out.print(sb);
    }
}