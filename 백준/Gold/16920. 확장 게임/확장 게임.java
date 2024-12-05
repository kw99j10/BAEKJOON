import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16920 확장 게임
class Main {
    static int n, m, p;
    static ArrayDeque<int[]>[] queue;
    static int[][] grid;
    static int[] scale;
    static int[] count;
    static boolean[][] visit;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        scale = new int[p + 1];
        count = new int[p + 1];
        st = new StringTokenizer(br.readLine());

        // 플레이어별 성의 확장 규모
        for (int i = 1; i <= p; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }

        queue = new ArrayDeque[p + 1];
        for (int i = 1; i <= p; i++) {
            queue[i] = new ArrayDeque<>();
        }

        visit = new boolean[n][m];
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);

                if (c == '#') {
                    grid[i][j] = -1; // 벽
                }

                // 빈칸이 아닌 숫자의 경우 => 플레이어 성
                else if (c != '.') {
                    queue[c - '0'].add(new int[]{i, j});
                    visit[i][j] = true;
                    count[c - '0'] += 1;
                }
            }
        }

        while (true) {
            if (game()) {
                break; // 확장할 수 없으면 게임 종료
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < p; i++) {
            sb.append(count[i]).append(" ");
        }
        sb.append(count[p]);
        System.out.print(sb);
    }

    static boolean game() {
        int finisher = 0; // 확장이 끝난 사람
        for (int i = 1; i <= p; i++) {
            if (queue[i].isEmpty()) {
                finisher++;
                continue;
            }
            bfs(i); // 플레이어 순서대로 확장게임
        }
        return finisher == p;
    }

    static void bfs(int playerNum) {

        // Si 칸 만큼만 이동가능
        int level = 0;
        while (!queue[playerNum].isEmpty() && scale[playerNum] > level) {
            // 플레이어 별 성의 개수 만큼 (동시 확장)
            int size = queue[playerNum].size();
            for (int i = 0; i < size; i++) {
                int[] current = queue[playerNum].poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + move[d][0];
                    int ny = y + move[d][1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || grid[nx][ny] != 0) {
                        continue;
                    }

                    grid[nx][ny] = playerNum;
                    visit[nx][ny] = true;
                    queue[playerNum].offer(new int[]{nx, ny});
                    count[playerNum]++; // 성 확장
                }
            }
            level++;
        }
    }
}