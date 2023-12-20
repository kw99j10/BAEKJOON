import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        while (queue.size() > 1) {
            int a = queue.remove();
            int b = queue.remove();

            min += a + b;
            queue.add(a + b);
        }
        System.out.println(min);
    }
}
