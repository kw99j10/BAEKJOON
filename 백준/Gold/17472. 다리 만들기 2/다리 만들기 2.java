import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17472 다리 만들기 2
public class Main {
    static class Island {
        int x, y, num;

        public Island(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int x, y, distance;

        public Bridge(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Bridge o) {
            return this.distance - o.distance; // 다리 길이의 최솟값
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static PriorityQueue<Bridge> brQueue = new PriorityQueue<>();
    static ArrayDeque<Island> queue = new ArrayDeque<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        int name = 1; // 섬의 번호
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    visit[i][j] = true;
                    dfs(i, j, map[i][j], name++);
                }
            }
        }

        // 각 섬을 하나의 집합으로 생각하여 연결
        parents = new int[name];
        for (int i = 1; i < name; i++) {
            parents[i] = i;
        }

        // 1. 현재 섬에서 다른 섬으로의 다리를 만듦
        while (!queue.isEmpty()) {
            Island current = queue.poll();

            // 4방향으로 다리 만들 수 있는지
            for (int d = 0; d < 4; d++) {
                makeIsland(current.x, current.y, d, current.num);
            }
        }

        // 2. 연결한 섬의 다리 길이 중 최소 다리 길이만을 선택

        int min = 0;
        int connect = 0;
        while (!brQueue.isEmpty()) {
            Bridge current = brQueue.poll();
            int first = current.x; // 현재 섬
            int second = current.y; // 다른 섬
            int len = current.distance;

            // 다리의 길이는 2 이상이어야 하며 서로 다른 섬을 연결하는 다리여야함
            if (len > 1 && find(first) != find(second)) {
                union(first, second);
                min += len;
                connect++;
            }
        }

        // 3. 모두 연결되어 있으면 최소 다리 길이의 합을 출력 아니면 -1
        System.out.println(connect == name - 2 ? min : -1);
    }

    static void dfs(int x, int y, int label, int name) {
        map[x][y] = name;
        queue.add(new Island(x, y, name));
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                continue;
            }
            if (map[nx][ny] == label) {
                visit[nx][ny] = true;
                dfs(nx, ny, label, name);
            }
        }
    }

    static void makeIsland(int x, int y, int d, int name) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        int distance = 0;

        // 섬에서 다른 섬까지의 다리 연결
        while (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != name) {
            if (map[nx][ny] != 0) {
                brQueue.add(new Bridge(name, map[nx][ny], distance));
                return;
            }
            nx += dx[d];
            ny += dy[d];
            distance++;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }
}