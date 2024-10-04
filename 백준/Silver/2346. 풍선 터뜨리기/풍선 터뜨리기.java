import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 2346 풍선 터뜨리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() != 1) {
            int last = queue.pollFirst();
            sb.append(last).append(" ");

            int move = arr[last];
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    queue.addLast(queue.pollFirst());
                }
            }else{
                for (int i = 0; i < Math.abs(move); i++) {
                    queue.addFirst(queue.pollLast());
                }
            }
        }
        sb.append(queue.peek());
        System.out.print(sb);
    }
}