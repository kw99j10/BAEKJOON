import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

// 1938 통나무 옮기기
public class Main {
    static int n;
    static char[][] grid;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> sx = new ArrayList<>(); // 시작점 bbb

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
                if (s.charAt(j) == 'B') {
                    sx.add(new int[]{i, j});
                }
            }
        }
        bfs();
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[n][n][2]; // 0: 가로, 1: 세로

        int dir = (sx.get(0)[0] == sx.get(1)[0] && sx.get(1)[0] == sx.get(2)[0]) ? 0 : 1;
        queue.add(new int[]{sx.get(1)[0], sx.get(1)[1], dir, 0});
        visit[sx.get(1)[0]][sx.get(1)[1]][dir] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int directions = current[2];
            int count = current[3];

            if (end(x, y, directions)) {
                System.out.println(count);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (move(nx, ny, directions) && !visit[nx][ny][directions]) {
                    visit[nx][ny][directions] = true;
                    queue.add(new int[]{nx, ny, directions, count + 1});
                }
            }

            if (rotate(x, y) && !visit[x][y][1-directions]) {
                visit[x][y][1 - directions] = true;
                queue.add(new int[]{x, y, 1 - directions, count + 1});
            }
        }
        System.out.println(0);
    }

    static boolean end(int x, int y, int d) {
        if (d == 0) {
            return grid[x][y - 1] == 'E' && grid[x][y] == 'E' && grid[x][y + 1] == 'E';
        } else {
            return grid[x + 1][y] == 'E' && grid[x][y] == 'E' && grid[x - 1][y] == 'E';
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != '1';
    }

    static boolean move(int x, int y, int d) {
        if (d == 0) {
            return check(x, y - 1) && check(x, y) && check(x, y + 1);
        } else {
            return check(x - 1, y) && check(x, y) && check(x + 1, y);
        }
    }

    static boolean rotate(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!check(x + i, y + j)) {
                    return false;
                }
            }
        }
        return true;
    }
}