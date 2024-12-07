import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 17143 낚시왕
class Main {
    static int r, c, m, startPoint;

    static class Shark {
        int s, d, z;

        public Shark(int s, int d, int z) {

            this.s = s; // 속력
            this.d = d; // 방향(0:위, 1:아래, 2:오른, 3:왼) -1
            this.z = z; // 크기
        }
    }

    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //위,아래,오른,왼
    static ArrayList<Shark>[][] grid;
    static ArrayList<Integer> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new ArrayList[r][c];
        initArray(grid);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            // (x,y): 상어 위치, s: 속력, d: 방향, z: 크기
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            grid[x][y].add(new Shark(s, d, z));
        }

        startPoint = 0; // 시작 위치
        // 오른쪽 열 끝에 도착
        while (startPoint != c) {
            fish(); // 낚시왕 이동 & 상어 잡음
            moveShark(); // 상어 이동
            startPoint++;
        }
        System.out.println(getSum());
    }

    static int getSum() {
        int sum = 0;
        for (Integer size : lists) {
            sum += size;
        }
        return sum;
    }

    static void fish() {
        for (int i = 0; i < r; i++) {
            if (grid[i][startPoint].isEmpty()) {
                continue;
            }

            // 2. 땅과 제일 가까운 상어를 잡음
            for (Shark shark : grid[i][startPoint]) {
                lists.add(shark.z);
                break;
            }
            grid[i][startPoint].clear(); // 잡은 상어 제거
            break;
        }
    }

    static void moveShark() {
        ArrayList<Shark>[][] tmp = new ArrayList[r][c];
        initArray(tmp);

        // 3. 상어 이동, 단, 격자판 경계를 넘으면 반대로 이동(이때,이동 거리가 리셋이 아닌 누적)
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (Shark shark : grid[i][j]) {

                    // 속력 최적화
                    if (shark.d <= 1) {
                        shark.s %= 2 * (r - 1);
                    } else {
                        shark.s %= 2 * (c - 1);
                    }

                    int x = i;
                    int y = j;
                    for (int k = 0; k < shark.s; k++) {
                        int nx = x + move[shark.d][0];
                        int ny = y + move[shark.d][1];

                        // 격자를 넘어갔으므로 이전 좌표로 이동
                        if (nx < 0 || nx >= r) {
                            x -= move[shark.d][0];
                            shark.d = shark.d == 1 ? 0 : 1;
                            continue;
                        }

                        if (ny < 0 || ny >= c) {
                            y -= move[shark.d][1];
                            shark.d = shark.d == 2 ? 3 : 2;
                            continue;
                        }
                        
                        x = nx;
                        y = ny;
                    }
                    tmp[x][y].add(shark);
                }
            }
        }

        // 4. 이동 후 한 칸에 두마리 이상의 상어가 있을 수 있음, 크기가 큰 상어가 모두 잡아 먹음
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (tmp[i][j].size() >= 2) {
                    int maxS = 0; // 속력
                    int maxD = 0; // 방향
                    int maxZ = 0; // 크기
                    for (Shark shark : tmp[i][j]) {
                        if (shark.z > maxZ) {
                            maxS = shark.s;
                            maxD = shark.d;
                            maxZ = shark.z;
                        }
                    }
                    tmp[i][j].clear();
                    tmp[i][j].add(new Shark(maxS, maxD, maxZ));
                }
            }
        }
        grid = tmp;
    }

    static void initArray(ArrayList<Shark>[][] grid) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }
    }
}