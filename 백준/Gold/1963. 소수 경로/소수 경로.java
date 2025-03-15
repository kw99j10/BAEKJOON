import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1963 소수 경로
public class Main {
    static boolean[] prime = new boolean[10001];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(prime, true);
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            for (int j = i + i; j <= 10000; j += i) {
                prime[j] = false; // 소수 검사
            }
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b);
            sb.append(min == Integer.MAX_VALUE ? "Impossible" : min).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int a, int b) {
        boolean[] visit = new boolean[10000];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[a] = true;
        queue.add(new int[]{a, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int time = current[1];
            if (num == b) {
                min = Math.min(min, time);
                return;
            }

            for (int i = 1000; i < 10000; i++) {
                if (!prime[i] || visit[i]) {
                    continue;
                }

                if (fourCheck(num, i) == 1) {
                    queue.add(new int[]{i, time + 1});
                    visit[i] = true; // 항상 네 자리 수를 유지해야 함
                }
            }
        }
    }

    static int fourCheck(int a, int b) {
        int cnt = 0;
        while (a != 0) {
            if (a % 10 != b % 10) {
                cnt++;
            }
            a /= 10;
            b /= 10;
        }
        return cnt;
    }
}