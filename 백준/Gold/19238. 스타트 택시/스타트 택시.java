import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 19238 스타트 택시
public class Main {
    static class Passenger implements Comparable<Passenger> {
        int x, y, distance;

        public Passenger(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Passenger o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }
    }

    static ArrayList<Passenger> goals = new ArrayList<>(); // 이동 목적지를 담을 리스트
    static int n, m, l, sx, sy, passNum;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1; //벽
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken()) - 1;
            int py = Integer.parseInt(st.nextToken()) - 1;
            int gx = Integer.parseInt(st.nextToken()) - 1;
            int gy = Integer.parseInt(st.nextToken()) - 1;

            map[px][py] = (i + 1); // 승객 번호
            goals.add(new Passenger(gx, gy, 0));
        }

        drive(); // 운행 시작
        System.out.println(m == 0 ? l : -1); // 승객을 다 이동시킨 경우
    }

    static void drive() {
        while (m != 0) {

            int firstFuel = findMan(); // 1. 승객을 찾음
            if (firstFuel > l || firstFuel == -1) {
                break;
            }

            l -= firstFuel; // 현재 연료량

            int secondFuel = goDestination(); // 2. 목적지로 이동
            if (secondFuel > l || secondFuel == -1) {
                break;
            }

            l += secondFuel; // 손님을 태우고 이동한 거리에 대해 연료 획득
            m--;
        }
    }

    static int findMan() {
        PriorityQueue<Passenger> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Passenger(sx, sy, 0));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Passenger current = queue.poll();
            int x = current.x;
            int y = current.y;
            int distance = current.distance;

            if (map[x][y] > 0) {
                passNum = map[x][y];
                sx = x;
                sy = y;
                map[x][y] = 0;
                return distance; // 승객 발견
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Passenger(nx, ny, distance + 1));
            }
        }
        return -1; // 승객을 못찾음
    }

    static int goDestination() {
        PriorityQueue<Passenger> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Passenger(sx, sy, 0));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Passenger current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (x == goals.get(passNum - 1).x && y == goals.get(passNum - 1).y) {
                sx = x;
                sy = y;
                return current.distance; // 목적지에 도착함
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Passenger(nx, ny, current.distance + 1));
            }

        }
        return -1;
    }
}