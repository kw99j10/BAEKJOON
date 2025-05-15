import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 20208 진우의 민트초코우유
public class Main {
    static int n, m, h, sx, sy, max;
    static int[][] grid;
    static boolean[][] visit;
    static ArrayList<int[]> milk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        milk = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j; // 집의 좌표
                }

                if (grid[i][j] == 2) {
                    milk.add(new int[]{i, j});
                }
            }
        }

        if (milk.isEmpty()) {
            System.out.println(0);
            return;
        }

        visit = new boolean[n][n];
        backtracking(sx, sy, m, 0);
        System.out.println(max);
    }

    static void backtracking(int x, int y, int hp, int count) {
        if (Math.abs(sx - x) + Math.abs(sy - y) <= hp) {
            max = Math.max(max, count);
        }

        for (int[] current : milk) {
            int cx = current[0];
            int cy = current[1];

            int dist = Math.abs(cx - x) + Math.abs(cy - y); // 우유까지의 거리
            if (visit[cx][cy] || dist > hp) {
                continue;
            }

            visit[cx][cy] = true;
            backtracking(cx, cy, hp - dist + h, count + 1);
            visit[cx][cy] = false;
        }
    }
}
