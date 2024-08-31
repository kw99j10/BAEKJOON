import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11060 점프 점프
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] maze = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(0); // 1칸은 점프할 필요 없음
            return;
        }

        int[] visit = new int[n];
        Arrays.fill(visit, Integer.MAX_VALUE);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visit[0] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            //maze[current] 이하만큼 점프 가능
            for (int d = 0; d <= maze[current]; d++) {
                int nx = current + d;

                if (nx >= n) {
                    continue;
                } else if (nx == n - 1) {
                    System.out.println(visit[current] + 1);
                    return;
                }

                if (visit[nx] > visit[current] + 1) {
                    visit[nx] = visit[current] + 1;
                    queue.add(nx);
                }
            }
        }
        System.out.println(-1);
    }
}