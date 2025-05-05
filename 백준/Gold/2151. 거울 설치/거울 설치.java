import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 2151 거울 설치
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

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, sx, sy, min;
    static char[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        house = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                house[i][j] = s.charAt(j);
                if (house[i][j] == '#') {
                    sx = i;
                    sy = j;
                }
            }
        }

        house[sx][sy] = '.';
        min = Integer.MAX_VALUE;
        bfs(sx, sy);
        System.out.println(min);
    }

    static void bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][][] visit = new boolean[n][n][4];

        for (int d = 0; d < 4; d++) {
            queue.add(new Node(x, y, d, 0));
            visit[x][y][d] = true;
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int cd = current.dir;
            int count = current.count;

            if (house[cx][cy] == '#') {
                min = Math.min(min, count);
                continue;
            }

            int nx = cx + dx[cd];
            int ny = cy + dy[cd];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny][cd] || house[nx][ny] == '*') {
                continue;
            }

            visit[nx][ny][cd] = true; // '.' 일 경우 그 방향으로 계속 이동
            queue.add(new Node(nx, ny, cd, count));

            if (house[nx][ny] == '!') { // 빛 굴절
                for (int d = 0; d < 4; d++) {
                    if (visit[nx][ny][d]) {
                        continue;
                    }
                    visit[nx][ny][d] = true;
                    queue.add(new Node(nx, ny, d, count + 1));
                }
            }
        }
    }
}