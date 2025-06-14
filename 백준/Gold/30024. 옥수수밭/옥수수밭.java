import java.io.*;
import java.util.*;

// 30024 옥수수밭
class Main {
    static class Corn implements Comparable<Corn> {
        int x, y, value;

        public Corn(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Corn o) {
            return o.value - this.value;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] grid;
    static boolean[][] visit;
    static int n, m, k;
    static PriorityQueue<Corn> queue = new PriorityQueue<>();
    static ArrayList<int[]> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        k = Integer.parseInt(br.readLine());

        visit = new boolean[n][m];
        border(); // 경계선 옥수수 수확부터 시작


        bfs();

        StringBuilder sb = new StringBuilder();
        for (int[] xy : lists) {
            sb.append(xy[0]).append(" ").append(xy[1]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        while (!queue.isEmpty() && k > lists.size()) {
            Corn corn = queue.poll();
            int x = corn.x;
            int y = corn.y;
            lists.add(new int[]{x + 1, y + 1});

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                queue.add(new Corn(nx, ny, grid[nx][ny]));
            }
        }
    }

    static void border() {
        for (int i = 0; i < n; i++) {
            if (!visit[i][0]) {
                visit[i][0] = true;
                queue.add(new Corn(i, 0, grid[i][0]));
            }

            if (!visit[i][m - 1]) {
                visit[i][m - 1] = true;
                queue.add(new Corn(i, m - 1, grid[i][m - 1]));
            }
        }

        for (int j = 1; j < m - 1; j++) {
            if (!visit[0][j]) {
                visit[0][j] = true;
                queue.add(new Corn(0, j, grid[0][j]));
            }

            if (!visit[n - 1][j]) {
                visit[n - 1][j] = true;
                queue.add(new Corn(n - 1, j, grid[n - 1][j]));
            }
        }
    }
}