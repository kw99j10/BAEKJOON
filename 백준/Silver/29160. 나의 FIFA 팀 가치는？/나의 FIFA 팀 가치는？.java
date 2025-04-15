import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 29160 나의 FIFA 팀 가치는?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 포지션별 우선순위를 담음
        ArrayList<PriorityQueue<Integer>> queue = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            queue.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.get(p).add(w);
        }

        long total = 0L;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= 11; j++) {
                if (!queue.get(j).isEmpty()) {
                    int top = queue.get(j).poll();
                    if (top > 0) {
                        queue.get(j).add(top - 1);
                    } // 선수 가치 하락
                }
            }

            long sum = 0L;
            for (int j = 1; j <= 11; j++) {
                if (!queue.get(j).isEmpty()) {
                    int top = queue.get(j).poll();
                    sum += top;
                    queue.get(j).add(top);
                }
            }
            total = sum;
        }
        System.out.println(total);
    }
}