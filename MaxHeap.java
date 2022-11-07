import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc = new Scanner(System.in);

        var heap = new PriorityQueue<Integer>(Collections.reverseOrder()); //자바 힙 구현 방법

        int n=sc.nextInt();

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x=sc.nextInt();

            if (x == 0) {
                if(heap.isEmpty())
                    sb.append(0).append("\n");

                else
                    sb.append(heap.poll()).append("\n");

            }
            else
                heap.add(x);
        }
        System.out.print(sb);
    }
}

