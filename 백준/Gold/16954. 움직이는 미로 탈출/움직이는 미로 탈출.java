import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//움직이는 미로 탈출
public class Main {
    static char[][] chess;

    //욱제가 이동할 수 있는 경우의 수
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chess = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                chess[i][j] = s.charAt(j);
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{7, 0}); //가장 왼쪽 아랫칸에서 시작

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean[][] visit = new boolean[8][8];
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (chess[x][y] == '#') {
                    continue;
                }

                if (x == 0 && y == 7) {
                    return 1;
                }

                for (int d = 0; d < 9; d++) {
                    int nx = x + move[d][0];
                    int ny = y + move[d][1];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || visit[nx][ny] || chess[nx][ny] == '#') {
                        continue;
                    }
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

            //욱제가 움직인 후 벽이 아래로 움직임
            for (int i = 7; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    if (chess[i][j] == '#') {
                        if (i < 7) {
                            chess[i + 1][j] = '#';
                        }
                        chess[i][j] = '.';
                    }
                }
            }
        }
        return 0;
    }
}