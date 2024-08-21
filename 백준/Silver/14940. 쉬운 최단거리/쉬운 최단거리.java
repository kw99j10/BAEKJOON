import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14940 쉬운 최단거리
public class Main {
    static int n, m, sx, sy;
    static int[][] arr;
    static int[][] distance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
        }
        distance[sx][sy] = 0;
        bfs(sx, sy);

        // 목표 지점까지의 거리 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (distance[i][j] == INF) {
                    if (arr[i][j] == 1) {
                        distance[i][j] = -1; // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치
                    } else if (arr[i][j] == 0) {
                        distance[i][j] = 0; // 방문할 수 없는 지역
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue; // 지도 밖
                }

                if (distance[nx][ny] == INF) {
                    if (arr[nx][ny] == 1) {
                        distance[nx][ny] = current[2] + 1;
                        queue.add(new int[]{nx, ny, current[2] + 1});
                    }
                }
            }
        }
    }
}