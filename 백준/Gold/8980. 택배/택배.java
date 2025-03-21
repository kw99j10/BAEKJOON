import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 8980 택배
public class Main {
    static class Truck implements Comparable<Truck> {
        int from, to, count;

        public Truck(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }

        @Override
        public int compareTo(Truck o) {
            if (this.to == o.to) {
                return this.from - o.from;
            }
            return this.to - o.to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을 수
        int c = Integer.parseInt(st.nextToken()); // 트럭 용량

        ArrayList<Truck> lists = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            lists.add(new Truck(from, to, count));
        }
        Collections.sort(lists);

        int sum = 0; // 최대 박스 수
        int[] country = new int[n + 1];

        for (Truck truck : lists) {
            int max = 0;
            for (int i = truck.from; i < truck.to; i++) {
                max = Math.max(max, country[i]);
            }

            int count = Math.min(c - max, truck.count); // 실을 수 있는 박스 수
            for (int i = truck.from; i < truck.to; i++) {
                country[i] += count;
            }
            sum += count;
        }
        System.out.println(sum);
    }
}