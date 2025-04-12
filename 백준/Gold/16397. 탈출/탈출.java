import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16397 탈출
public class Main {
    static int n, t, g, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        bfs();
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[100000];
        queue.add(new int[]{n, 0});
        visit[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int count = current[1];

            if (count > t) {
                System.out.println("ANG");
                return;
            }

            if (num == g) {
                min = Math.min(min, count);
                System.out.println(min);
                return;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    int tmp = num + 1;

                    if (99999 >= tmp && !visit[tmp]) {
                        visit[tmp] = true;
                        queue.add(new int[]{tmp, count + 1});
                    }
                } else {
                    int tmp = num * 2;
                    if (num != 0 && 99999 >= tmp) {
                        String s = String.valueOf(tmp);
                        int k = (s.charAt(0) - '0') - 1;

                        s = (k == 0) ? s.substring(1) : k + s.substring(1);
                        int change = Integer.parseInt(s);

                        if (!visit[change]) {
                            visit[change] = true;
                            queue.add(new int[]{change, count + 1});
                        }
                    }
                }
            }
        }
        System.out.println("ANG");
    }
}