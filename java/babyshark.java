import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//아기 상어어
public class Main {
    static int n;
    static int[][] space;
    static boolean[][] visit;
    static int sharkSize = 2;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int currentX, currentY; //현재 아기 상어의 좌표
    static int eatCount;
    static int eatTime = -1;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        space = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                //아기 상어의 위치를 저장
                if (space[i][j] == 9) {
                    currentX = i;
                    currentY = j;
                    space[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.println(answer);
    }
    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{currentX, currentY});
        visit[currentX][currentY] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            eatTime++;

            boolean flag = false;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            while (size-- > 0) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                //햔재 좌표에서 먹이를 먹을 수 있는 경우
                if (space[x][y] != 0 && space[x][y] != 9 && sharkSize > space[x][y]) {
                    if (minX > x) {
                        minX = x;
                        minY = y;
                    } else if (minX == x) {
                        if (minY > y) {
                            minY = y;
                        }
                    }
                    flag = true;
                    continue;
                }

                //그렇지 않다면 좌표를 이동하여 탐색을 수행
                if (!flag) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }

                        if (visit[nx][ny] || space[nx][ny] > sharkSize) {
                            continue;
                        }
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            if (flag) {
                eatCount++;
                answer = eatTime;

                space[currentX][currentY] = 0;
                space[minX][minY] = 9;

                currentX = minX;
                currentY = minY;

                if (sharkSize == eatCount) {
                    sharkSize++;
                    eatCount = 0;
                }

                //좌표가 바뀔 때마다 탐색이 달라지므로 큐와 방문 배열을 초기화
                queue = new ArrayDeque<>();
                visit = new boolean[n][n];
                queue.add(new int[]{currentX, currentY});
                visit[currentX][currentY] = true;
                eatTime--;
            }
        }
    }
}
