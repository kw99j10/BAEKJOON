import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 15558 점프 게임
public class Main {
    static int n, k;
    static boolean isPossible = false;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[n];
        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
            a[i] = s1.charAt(i) - '0';
            b[i] = s2.charAt(i) - '0';
        }
        bfs();
        System.out.println(isPossible ? 1 : 0);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][2];
        queue.add(new int[]{0, 0}); // 0은 a, 1은 b 줄
        visit[0][0] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] current = queue.poll();
                int x = current[0];
                int col = current[1];

                if (count > x) {
                    continue;
                }

                // 1. 유저가 이동함
                for (int i = 0; i < 3; i++) {
                    int nx;
                    int ncol = col;
                    // 1. 앞으로 한칸
                    if (i == 0) {
                        nx = x + 1;
                    }

                    // 2. 뒤로 한칸
                    else if (i == 1) {
                        nx = x - 1;
                    }

                    // 3. 줄 바꿈
                    else {
                        nx = x + k;
                        ncol = 1 - col;
                    }

                    if (nx >= n) {
                        isPossible = true;
                        return;
                    }

                    if (nx > count && !visit[nx][ncol] && (ncol == 0 ? a[nx] : b[nx]) == 1) {
                        visit[nx][ncol] = true;
                        queue.add(new int[]{nx, ncol});
                    }
                }
            }
            count++;
        }
    }
}