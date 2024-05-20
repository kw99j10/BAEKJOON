import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 돌다리
public class Main {
    static int a, b, n, m;
    static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
            return;
        }
        bfs();
    }
    static void bfs() {
        boolean[] visit = new boolean[100001];
        visit[n] = true;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            int[] move = {current + 1, current - 1, current + a, current + b,
                    current * a, current * b, current - a, current - b};

            for (int i = 0; i < 8; i++) {
                int nx = move[i];

                if (nx == m) {
                    System.out.println(count[current] + 1);
                    return;
                }

                if (nx < 0 || nx >= 100000 || visit[nx]) {
                    continue;
                }
                visit[nx] = true;
                queue.add(nx);
                count[nx] = count[current] + 1;
            }
        }
    }
}