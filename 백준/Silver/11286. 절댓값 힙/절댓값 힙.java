import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 11286 절댓값 힙
public class Main {
    static class Number implements Comparable<Number> {
        int x;

        public Number(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Number o) {
            if (Math.abs(this.x) == Math.abs(o.x)) {
                return this.x - o.x;
            }
            return Math.abs(this.x) - Math.abs(o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Number> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(queue.poll().x);
                }
                sb.append("\n");
            } else {
                queue.add(new Number(num));
            }
        }
        System.out.print(sb);
    }
}