import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 17129 윌리암슨~
public class Main {
    static int n, m, sx, sy, answer;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 가족:2, 청국장:3, 스시:4, 맥엔치즈 5
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        // 가족이 있는 위치에서 시작
        if (bfs(sx, sy)) {
            System.out.println("TAK");
            System.out.println(answer);
        } else {
            System.out.println("NIE");

        }
    }

    static boolean bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];

        visit[i][j] = true;
        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) {
                answer = distance; // 가장 빨리 도착한 음식
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, distance + 1});
            }
        }
        return false;
    }
}