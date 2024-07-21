import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 13975 파일 합치기 3
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            long sum = 0;
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= k; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            while (queue.size() != 1) {
                long a = queue.remove();
                long b = queue.remove();
                sum += a + b;
                queue.add(a + b);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}