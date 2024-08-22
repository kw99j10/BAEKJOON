import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 12886 돌 그룹
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, C));
    }

    static int bfs(int A, int B, int C) {
        ArrayDeque<int []> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[2001][2001]; //나올 수 있는 최대 경우의 수
        queue.add(new int[]{A, B, C});
        visit[A][B] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];

            if (a == b && b == c) {
                return 1;
            }

            if (a != b) {
                int x = a > b ? a - b : a + a;
                int y = a > b ? b + b : b - a;

                if (!visit[x][y]) {
                    visit[x][y] = true;
                    queue.add(new int[]{x, y, c});
                }
            }

            if (b != c) {
                int x = b > c ? b - c : b + b;
                int y = b > c ? c + c : c - b;

                if (!visit[x][y]) {
                    visit[x][y] = true;
                    queue.add(new int[]{a, x, y});
                }
            }

            if (a != c) {
                int x = a > c ? a - c : a + a;
                int y = a > c ? c + c : c - a;

                if (!visit[x][y]) {
                    visit[x][y] = true;
                    queue.add(new int[]{x, b, y});
                }
            }
        }
        return 0;
    }
}