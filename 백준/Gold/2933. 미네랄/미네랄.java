import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2933 미네랄
public class Main {
    static int r, c, line, number, fNum;
    static char[][] cave;
    static boolean[][] visit;
    static int[][] cluster;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cave = new char[r][c];
        for (int i = 0; i < r; i++) {
            cave[i] = br.readLine().toCharArray();
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visit = new boolean[r][c];
            cluster = new int[r][c]; // 클러스터 라벨링 위함
            line = r - (Integer.parseInt(st.nextToken())); // 파괴할 칸

            // 1. 막대기가 해당 칸 미네랄을 파괴
            if (i % 2 == 0) {
                destroyLeft();
            } else {
                destroyRight();
            }

            // 2. 클러스터 검사 및 라벨링
            check();

            // 3. 연결된 클러스터가 중력에 의해 떨어짐
            gravity();
        }
        printArray();
    }

    static void destroyLeft() {
        for (int i = 0; i < c; i++) {
            if (cave[line][i] == 'x') {
                cave[line][i] = '.';
                break;
            }
        }
    }
    static void destroyRight() {
        for (int i = c - 1; i >= 0; i--) {
            if (cave[line][i] == 'x') {
                cave[line][i] = '.';
                break;
            }
        }
    }

    static void check() {
        number = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cave[i][j] == 'x' && !visit[i][j]) {
                    dfs(i, j, number++); // 클러스터 생성
                }
            }
        }
    }

    static void gravity() {
        if (checkCluster()) { // 클러스터 중력 여부 체크
            boolean[][] check = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (cluster[i][j] == fNum) {
                        check[i][j] = true;
                    }
                }
            }

            int min = r; // 클러스터는 한 번에 떨어짐
            for (int j = 0; j < c; j++) {
                for (int i = r - 1; i >= 0; i--) {
                    if (check[i][j]) {
                        int h = 0;
                        for (int k = i + 1; k < r; k++) {
                            if (cave[k][j] == 'x' && !check[k][j]) {
                                break;
                            }
                            h++;
                        }
                        min = Math.min(min, h);
                    }
                }
            }

            for (int j = 0; j < c; j++) {
                for (int i = r - 1; i >= 0; i--) {
                    if (check[i][j]) {
                        cave[i][j] = '.';
                        cave[i + min][j] = 'x';
                    }
                }
            }
        }
    }

    static boolean checkCluster() {
        boolean[] ground = new boolean[number];
        for (int j = 0; j < c; j++) {
            if (cluster[r - 1][j] > 0) {
                ground[cluster[r - 1][j]] = true;
            }
        }


        boolean isFalling = false; // 떨어질 클러스터가 있는지
        fNum = 0; // 떨어질 클러스터 번호
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cluster[i][j] > 0 && !ground[cluster[i][j]]) {
                    isFalling = true;
                    fNum = cluster[i][j];
                    break;
                }
            }
            if (isFalling) {
                break;
            }
        }
        return isFalling;
    }

    static void dfs(int x, int y, int num) {
        visit[x][y] = true;
        cluster[x][y] = num;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny]) {
                continue;
            }
            if (cave[nx][ny] == 'x') {
                dfs(nx, ny, num);
            }
        }
    }

    static void printArray() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(cave[i][j]);
            }
            System.out.println();
        }
    }
}