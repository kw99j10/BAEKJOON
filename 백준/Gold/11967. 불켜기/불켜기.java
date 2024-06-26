import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 불켜기
public class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static ArrayList<Node>[][] farm;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        farm = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                farm[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            farm[x][y].add(new Node(a, b));
        }
        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 1));
        boolean[][] visit = new boolean[n + 1][n + 1]; // 방을 방문했는지 여부는 초기화
        boolean[][] turnOn = new boolean[n + 1][n + 1]; // 방이 불이 켜져 있는지 여부
        turnOn[1][1] = true; //시작하는 방은 불이 켜져있음
        visit[1][1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;

            // 베시의 현재 위치에서 불을 켤 수 있는 방의 개수
            for (Node next : farm[x][y]) {
                int nx = next.x;
                int ny = next.y;
                if (!turnOn[nx][ny] && visit[nx][ny]) {
                    queue.add(new Node(nx, ny)); //방문 가능한 위치
                }
                turnOn[nx][ny] = true;
            }

            // 현재 위치에서 이동할 수 있는 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || nx > n || ny < 1 || ny > n) {
                    continue;
                }

                if (turnOn[nx][ny] && !visit[nx][ny]) {
                    queue.add(new Node(nx, ny));
                }
                visit[nx][ny] = true; // 현재 위치에서 방문할 수 있는 곳
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (turnOn[i][j]) {
                    count++; //불이 켜진 방
                }
            }
        }
        return count;
    }
}