import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 3078 좋은 친구
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long count = 0L;
        ArrayDeque<Integer>[] queue = new ArrayDeque[21];
        for (int i = 1; i <= 20; i++) {
            queue[i] = new ArrayDeque<>();
        }
        for (int i = 1; i <= n; i++) {
            int name = br.readLine().length();
            if (!queue[name].isEmpty()) {
                // 등수의 차이가 K보다 작거나 같으면서 이름의 길이가 같은 친구
                while (!queue[name].isEmpty() && i - queue[name].peek() > k) {
                    queue[name].poll();
                }
                count += queue[name].size();
            }
            queue[name].add(i);
        }
        System.out.println(count);
    }
}
