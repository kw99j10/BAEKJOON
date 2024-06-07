import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1417 국회의원 선거
public class Main {
    static class Person implements Comparable<Person> {
        int num, count;

        public Person(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Person o) {
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Person> queue = new PriorityQueue<>();

        int dasom = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());
            queue.add(new Person(i, k));
        }

        int min = 0;
        while (!queue.isEmpty()) {
            Person current = queue.poll();

            if (dasom > current.count) {
                break;
            }

            dasom++;
            min++;
            current.count--;
            queue.add(current);
        }
        System.out.println(min);
    }
}