import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16918 봄버맨
public class Main {
    static int r, c, n;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static char[][] grid;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'O') {
                    visit[i][j] = true; // 초기 상태
                }
            }
        }

        if (n == 1) {
            printGrid();
            return;
        }

        int time = 2; // 1초가 이미 지난 상태
        while (time <= n) {
            if (time % 2 == 0) {
                place(); // 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
            } else{
                bomb(); // 3초 전 설치된 폭탄이 모두 폭발
            }
            time++;
        }
        printGrid();
    }
    static void place() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    static void bomb() {
        char [][]tmpGrid = new char[r][c];
        boolean[][]tmpVisit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visit[i][j]) {
                    tmpGrid[i][j] = '.';
                    check(i, j, tmpGrid);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (tmpGrid[i][j] != '.') {
                    tmpGrid[i][j] = 'O';
                    tmpVisit[i][j] = true;
                }
            }
        }

        grid = tmpGrid;
        visit = tmpVisit;
    }

    static void check(int x, int y, char[][] tmpGrid) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            tmpGrid[nx][ny] = '.'; // 4방향 폭발
        }
    }

    static void printGrid() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}