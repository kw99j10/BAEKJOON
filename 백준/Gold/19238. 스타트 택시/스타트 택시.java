import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//스타트 택시
public class Main {
    static class Passenger implements Comparable<Passenger> {
        int x, y, distance;

        public Passenger(int x, int y, int distance) {
            this.x = x; //승객 좌표
            this.y = y;
            this.distance = distance; //승객 까지의 거리
        }

        @Override
        public int compareTo(Passenger o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }
            }
            return this.distance - o.distance;
        }
    }

    static int n, l, sx, sy, sc;
    static int[][] grid;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Passenger> pass;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    grid[i][j] = -1; //벽 표시
                }
            }
        }
        st = new StringTokenizer(br.readLine());

        //택시가 시작할 좌표
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        pass = new ArrayList<>(); //승객 리스트
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken()) - 1;
            int py = Integer.parseInt(st.nextToken()) - 1;

            int gx = Integer.parseInt(st.nextToken()) - 1;
            int gy = Integer.parseInt(st.nextToken()) - 1;

            grid[px][py] = i; //승객 번호
            pass.add(new Passenger(gx, gy, 0));
        }

        //고객까지의 거리 탐색 -> 목적지까지의 거리 탐색
        while (m > 0) {
            int useFuel = searchPassenger();

            //고객에게 갈 수 없거나 연료가 부족할 경우
            if (useFuel == -1 || useFuel > l) {
                System.out.println(-1);
                return;
            }

            int useFuel2 = searchDestination();

            //목적지로 갈 수 없거나 연료가 부족할 경우
            if (useFuel2 + useFuel > l || useFuel2 == -1) {
                System.out.println(-1);
                return;
            }
            l += useFuel2 - useFuel;
            m--;
        }
        System.out.println(l);
    }

    static int searchPassenger() {

        //현재 택시 위치 -> 고객이 있는 위치
        PriorityQueue<Passenger> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Passenger(sx, sy, 0));
        visit[sx][sy] = true;

        while (!queue.isEmpty()) {
            Passenger current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            //고객을 태운 경우
            if (grid[cx][cy] > 0) {
                sc = grid[cx][cy]; //현재 고객 위치 정보 & 좌표 갱신
                sx = cx;
                sy = cy;
                grid[sx][sy] = 0;
                return current.distance; //사용한 연료
            }

            //고객을 못태운 경우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + move[d][0];
                int ny = cy + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Passenger(nx, ny, current.distance + 1));
            }
        }
        return -1;
    }

    static int searchDestination() {
        //고객이 있는 좌표 -> 목적지 좌표
        PriorityQueue<Passenger> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        queue.add(new Passenger(sx, sy, 0));
        visit[sx][sy] = true;

        int gx = pass.get(sc - 1).x;
        int gy = pass.get(sc - 1).y;

        while (!queue.isEmpty()) {
            Passenger current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            //목적지에 도착한 경우 현재 택시 위치 갱신
            if (cx == gx && cy == gy) {
                sx = gx;
                sy = gy;
                return current.distance;
            }

            //목적지 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + move[d][0];
                int ny = cy + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == -1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new Passenger(nx, ny, current.distance + 1));
            }
        }
        return -1;
    }
}