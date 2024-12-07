import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 23290 마법사 상어와 복제
class Main {
    static int m, s, sx, sy;

    static class Fish {
        int x, y, dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int[][] dirShark = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //상,좌,하,우 사전순
    static int[][] dirFish = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}}; //8방향
    static ArrayList<Fish>[][] grid;
    static int[][] smellVisit = new int[4][4]; // 물고기 냄새 탐지;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        grid = new ArrayList[4][4];
        initArray(grid);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()) - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            grid[fx][fy].add(new Fish(fx, fy, d));
        }

        st = new StringTokenizer(br.readLine());
        // 현재 마법사 상어 위치
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < s; i++) {
            magic();
        }

        int cnt = 0; // 격자 물고기 개수
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cnt += grid[i][j].size();
            }
        }
        System.out.println(cnt);
    }

    static void magic() {

        //1. 복제 마법 시전: 실행 대기
        ArrayList<Fish>[][] copy = new ArrayList[4][4];
        initArray(copy);
        copyArray(copy);

        // 2. 물고기 한 칸 이동
        fishMove();

        // 3. 상어 연속 3칸 이동
        sharkMove();

        //4. 두 번 전 연습에서 생긴 물고기 냄새가 격자에서 사라짐
        fadeSmell();

        //5. 복제 마법 완료, 1에서의 위치와 방향을 갖게 됨
        replication(copy);
    }

    static void replication(ArrayList<Fish>[][] copy) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j].addAll(copy[i][j]);
            }
        }
    }

    static void fishMove() {
        ArrayList<Fish>[][] tmp = new ArrayList[4][4]; // 물고기가 이동한 좌표
        initArray(tmp);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!grid[i][j].isEmpty()) { // 물고기가 있는 경우
                    for (Fish fish : grid[i][j]) {
                        int x = fish.x;
                        int y = fish.y;
                        int d = fish.dir;

                        boolean isPossible = false; // 물고기 이동 가능 여부

                        // 이동할 수 있을 때까지 45도 반시계 회전
                        for (int k = 0; k < 8; k++) {
                            int nx = x + dirFish[d][0];
                            int ny = y + dirFish[d][1];

                            // 상어 있는 칸, 물고기 냄새 있는 칸, 격자 범위 벗어나는 칸  이동 x
                            if ((nx >= 0 && nx < 4 && ny >= 0 && ny < 4) && (nx != sx || ny != sy) && smellVisit[nx][ny] == 0) {
                                isPossible = true;
                                tmp[nx][ny].add(new Fish(nx, ny, d));
                                break;
                            }
                            d = (d + 7) % 8;
                        }

                        if (!isPossible) {
                            tmp[x][y].add(new Fish(x, y, d)); // 이동이 불가능한 경우
                        }
                    }
                }
            }
        }
        grid = tmp; // 배열 갱신
    }

    static void sharkMove() {
        int max = -1; // 먹은 물고기가 0일 수도 있음
        int[] path = new int[3]; // 최적 경로 저장

        // 64가지 경우 탐색 (4x4x4)
        for (int d1 = 0; d1 < 4; d1++) {
            int nx1 = sx + dirShark[d1][0];
            int ny1 = sy + dirShark[d1][1];
            if (valid(nx1, ny1)) continue;

            int cnt1 = grid[nx1][ny1].size();

            for (int d2 = 0; d2 < 4; d2++) {
                int nx2 = nx1 + dirShark[d2][0];
                int ny2 = ny1 + dirShark[d2][1];
                if (valid(nx2, ny2)) continue;

                // 같은 칸일 경우 물고기를 중복 먹지 않도록 조건 처리
                int cnt2 = cnt1;
                if (nx2 != nx1 || ny2 != ny1) {
                    cnt2 += grid[nx2][ny2].size();
                }

                for (int d3 = 0; d3 < 4; d3++) {
                    int nx3 = nx2 + dirShark[d3][0];
                    int ny3 = ny2 + dirShark[d3][1];
                    if (valid(nx3, ny3)) continue;

                    // 같은 칸일 경우 물고기를 중복 먹지 않도록 조건 처리
                    int cnt3 = cnt2;
                    if ((nx3 != nx1 || ny3 != ny1) && (nx3 != nx2 || ny3 != ny2)) {
                        cnt3 += grid[nx3][ny3].size();
                    }

                    // 사전순으로 가장 앞서는 경로와 최대값 갱신
                    if (cnt3 > max) {
                        max = cnt3;
                        path[0] = d1;
                        path[1] = d2;
                        path[2] = d3;
                    }
                }
            }
        }

        // 최적 경로를 따라 상어 이동 및 물고기 처리
        int nx = sx, ny = sy;
        for (int dir : path) {
            nx += dirShark[dir][0];
            ny += dirShark[dir][1];

            // 물고기를 제거하고 냄새를 남김
            if (!grid[nx][ny].isEmpty()) {
                grid[nx][ny].clear();
                smellVisit[nx][ny] = 3;
            }
        }

        // 상어 위치 갱신
        sx = nx;
        sy = ny;
    }

    static void fadeSmell() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (smellVisit[i][j] > 0) {
                    smellVisit[i][j] -= 1;
                }
            }
        }
    }

    static boolean valid(int nx, int ny) {
        return nx < 0 || nx >= 4 || ny < 0 || ny >= 4;
    }

    static void initArray(ArrayList<Fish>[][] tmp) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = new ArrayList<>();
            }
        }
    }

    static void copyArray(ArrayList<Fish>[][] copy) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (Fish fish : grid[i][j]) {
                    copy[i][j].add(new Fish(fish.x, fish.y, fish.dir));
                }
            }
        }
    }
}