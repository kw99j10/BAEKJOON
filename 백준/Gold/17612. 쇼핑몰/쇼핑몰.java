import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17612 쇼핑몰
public class Main {
    static class Shop implements Comparable<Shop> {
        int id, time, counter;

        public Shop(int id, int time, int counter) {
            this.id = id;
            this.time = time;
            this.counter = counter;
        }

        public int compareTo(Shop o) {
            // 계산대에서 계산을 마친 시간이 같다면 가장 큰 번호 계산대 고객부터 먼저 나감
            if (o.time == this.time) {
                return o.counter - this.counter;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 카운트 개수

        PriorityQueue<Shop> charge = new PriorityQueue<>(); // 계산 큐
        ArrayDeque<Shop> wait = new ArrayDeque<>(); // 대기 큐
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()); // 회원번호, 물건 수
            int w = Integer.parseInt(st.nextToken());
            wait.add(new Shop(id, w, 0));
        }

        // 번호가 가장 작은 계산대로 안내
        PriorityQueue<Integer> counter = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            counter.add(i);
        }

        long sum = 0L;
        int count = 1;
        while (!charge.isEmpty() || !wait.isEmpty()) {

            while (!wait.isEmpty() && !counter.isEmpty()) {
                Shop next = wait.poll();
                int cNum = counter.poll();
                charge.add(new Shop(next.id, next.time, cNum));
            }

            int out = charge.peek().time; // 시간 순서대로 빠져나감
            for (Shop shop : charge) {
                shop.time -= out;
            }

            while (!charge.isEmpty() && charge.peek().time == 0) {
                Shop current = charge.poll();
                counter.add(current.counter); // 카운터 계산 가능
                sum += (long) current.id * count;
                count++;
            }
        }
        System.out.println(sum);
    }
}