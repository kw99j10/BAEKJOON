import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 23843 콘센트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> count = new PriorityQueue<>(); // 최소시간 큐
        for (int i = 0; i < m; i++) {
            count.add(0);
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int time = queue.poll() + count.poll();
            count.add(time);
            answer = Math.max(answer, time);
        }
        System.out.println(answer);
    }
}