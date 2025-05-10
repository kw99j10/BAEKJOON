import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 6087 레이저 통신
public class Main {
    static class Node implements Comparable<Node> {
        int x, y, dir, count;

        public Node(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    static int w, h, sx, sy, min = Integer.MAX_VALUE;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'C') {
                    sx = i;
                    sy = j;
                }
            }
        }
        map[sx][sy] = '.';
        bfs(sx, sy);
        System.out.println(min);
    }

    static void bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[][][] distance = new int[h][w][4];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int d = 0; d < 4; d++) {
                    distance[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            queue.add(new Node(x, y, d, 0));
            distance[x][y][d] = 0;
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int dir = current.dir;
            int count = current.count;

            if (map[cx][cy] == 'C') {
                min = Math.min(min, count);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '*') {
                    continue;
                }

                int nc = (d == dir) ? count : count + 1;
                if (distance[nx][ny][d] > nc) {
                    distance[nx][ny][d] = nc;
                    queue.add(new Node(nx, ny, d, nc));
                }
            }
        }
    }
}
