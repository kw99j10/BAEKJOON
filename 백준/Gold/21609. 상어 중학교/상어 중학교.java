import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 21609 상어 중학교
public class Main {
    static class Group implements Comparable<Group> {
        int sx, sy, rainbow, cnt;

        public Group(int sx, int sy, int rainbow, int cnt) {
            this.sx = sx;
            this.sy = sy;
            this.rainbow = rainbow;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Group o) {
            if (this.cnt == o.cnt) {
                if (this.rainbow == o.rainbow) {
                    if (this.sx == o.sx) {
                        return o.sy - this.sy;
                    }
                    return o.sx - this.sx;
                }
                return o.rainbow - this.rainbow;
            }
            return o.cnt - this.cnt;
        }
    }

    static int n, m, rainbow, size, sum;
    static int[][] grid;
    static PriorityQueue<Group> lists;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) {
                    grid[i][j] = 99; // 무지개 블록 정보 변경
                }
            }
        }

        while (true) {
            findBlock(); // 블록 집합 찾기

            if (lists.isEmpty()) {
                break;
            }

            autoPlay(); // 오토 플레이
        }
        System.out.println(sum);
    }

    static void findBlock() {
        visit = new boolean[n][n];
        lists = new PriorityQueue<>(); // 블록 정보 리스트

        // 일반 블록의 색은 모두 같아야 함 & 검은색 블록 존재 x, 무지개 블록 상관 없음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && (grid[i][j] > 0 && grid[i][j] <= m)) {
                    rainbow = 0;
                    size = 0;
                    dfs(i, j, grid[i][j]);

                    // 개수가 2개 이상인 블록만
                    if (size >= 2) {
                        lists.add(new Group(i, j, rainbow, size));
                    }
                    resetRainbow();
                }
            }
        }
    }

    static void autoPlay() {
        deleteBlock(); // 1. 크기가 가장 큰 블록 그룹을 찾아서 제거

        gravity(); // 2. 격자에 중력 작용

        rotation(); // 3. 격자가 90도 반시계 방향으로 회전

        gravity(); // 4. 다시 격자에 중력 작용
    }

    static void deleteBlock() {
        if (!lists.isEmpty()) {
            Group bigBlock = lists.poll();

            boolean[][] visit = new boolean[n][n];
            ArrayDeque<int[]> queue = new ArrayDeque<>();

            int x = bigBlock.sx;
            int y = bigBlock.sy;
            int color = grid[x][y];
            int size = bigBlock.cnt;
            queue.add(new int[]{x, y});
            visit[x][y] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                        continue;
                    }

                    if (grid[nx][ny] == color || grid[nx][ny] == 99) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            sum += (int) Math.pow(size, 2); // B^2점 획득

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) {
                        grid[i][j] = 0; // 점수 획득 후 블록 제거
                    }
                }
            }
        }
    }

    static void gravity() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 2; i >= 0; i--) {
                if (grid[i][j] > 0) {
                    int nx = i;
                    int ny = j;

                    // 중력 적용
                    while (n > nx + 1 && grid[nx + 1][ny] == 0) {
                        grid[nx + 1][ny] = grid[nx][ny];
                        grid[nx][ny] = 0;
                        nx++;
                    }
                }
            }
        }
    }

    static void rotation() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[n - j - 1][i] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp[i][j];
            }
        }
    }

    static void dfs(int x, int y, int color) {
        visit[x][y] = true;
        size++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
                continue;
            }

            // 같은 블록이거나 무지개 블록인 경우
            if (grid[nx][ny] == color || grid[nx][ny] == 99) {
                if (grid[nx][ny] == 99) {
                    rainbow++;
                }
                dfs(nx, ny, color);
            }
        }
    }

    static void resetRainbow() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 99) {
                    visit[i][j] = false; // 무지개 블록은 방문 초기화 (다음 블록 그룹)
                }
            }
        }
    }
}