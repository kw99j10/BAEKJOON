import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 농장 관리
public class Main {
    static int n, m, count;
    static int[][] mountain;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mountain = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        int tmp = mountain[x][y]; //현재 격자

        boolean isPossible = true; //산봉우리가 생길 수 있는지

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    
                    // 산봉우리가 아님
                    if (mountain[nx][ny] > tmp) {
                        isPossible = false;
                    }

                    // 같은 높이를 가지는 하나의 격자 혹은 인접한 격자들의 집합
                    else if (!visit[nx][ny] && mountain[nx][ny] == tmp) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        if (isPossible) {
            count++;
        }
    }
}