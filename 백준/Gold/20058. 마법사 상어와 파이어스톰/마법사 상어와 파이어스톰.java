import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 20058 마법사 상어와 파이어스톰
class Main {
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static int n, q, max;
    static int[][] grid;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2, n);
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        level = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            firestorm(level[i]); // 레벨에 따른 파이어 스톰
            checkIce(); // 얼음 녹음
        }


        visit = new boolean[n][n];
        int sum = 0; // 남아있는 얼음의 합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visit[i][j]) {
                    bfs(i, j); // 덩어리 확인
                }
                sum += grid[i][j];
            }
        }
        System.out.println(sum);
        System.out.println(max);
    }

    static void firestorm(int level) {
        // 1. 단계 l을 결정 (2l x 2l 크기)
        int[][] tmp = new int[n][n];
        copyArray(tmp);

        level = (int) Math.pow(2, level); // 레벨 만큼 이동
        for (int i = 0; i < n; i += level) {
            for (int j = 0; j < n; j += level) {
                rotate(i, j, level, tmp); // 2. 격자 부분 시계 방향 90도 회전
            }
        }
        grid = tmp; // 배열 갱신
    }

    static void copyArray(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = grid[i][j];
            }
        }
    }

    static void checkIce() {
        // 3. 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸 얼음 1 감소 (코너 얼음?)
        boolean[][] tmp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    continue; // 얼음이 없을 경우 넘어감
                }

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + move[d][0];
                    int ny = j + move[d][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                        continue;
                    }
                    cnt++;
                }
                if (cnt < 3) {
                    tmp[i][j] = true;
                }
            }
        }

        melt(tmp);
    }

    static void melt(boolean[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp[i][j] ? grid[i][j] - 1 : grid[i][j];
            }
        }
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visit[i][j] = true;

        int count = 1; // 집합의 개수
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == 0) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        max = Math.max(max, count);
    }

    static void rotate(int x, int y, int level, int[][] tmp) {
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                tmp[x + j][y + level - i - 1] = grid[x + i][y + j];
            }
        }
    }
}