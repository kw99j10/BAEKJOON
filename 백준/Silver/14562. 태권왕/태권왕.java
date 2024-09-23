import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//14562 태권왕
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            ArrayDeque<int []> queue = new ArrayDeque<>();
            queue.add(new int[]{s, t, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int now = current[0];
                int target = current[1];
                int min = current[2];

                if (now > target) {
                    continue;
                }
                if (now == target) {
                    sb.append(min).append("\n");
                    break;
                }
                queue.add(new int[]{now * 2, target + 3, min + 1});
                queue.add(new int[]{now + 1, target, min + 1});
            }
        }
        System.out.print(sb);
    }
}