import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9207 페그 솔리테어
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static int max, minMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            map = new char[5][9];
            for (int j = 0; j < 5; j++) {
                map[j] = br.readLine().toCharArray();
            }

            String line = br.readLine();

            max = Integer.MAX_VALUE;
            minMove = 0;
            dfs(0);
            sb.append(max).append(" ").append(minMove).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int cnt) {
        // 핀을 두번 꼽아야 움직일 수 있음
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 'o') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 9) {
                            continue;
                        }

                        if (map[nx][ny] == 'o') {
                            int nnx = nx + dx[d];
                            int nny = ny + dy[d];

                            if (nnx < 0 || nnx >= 5 || nny < 0 || nny >= 9) {
                                continue;
                            }

                            if (map[nnx][nny] == '.') {
                                map[i][j] = map[nx][ny] = '.';
                                map[nnx][nny] = 'o';
                                dfs(cnt + 1); // 움직인 횟수
                                map[nnx][nny] = '.';
                                map[i][j] = map[nx][ny] = 'o';
                            }
                        }
                    }
                }
            }
        }

        count(cnt);
    }

    static void count(int idx) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 'o') {
                    count++;
                }
            }
        }
        max = Math.min(max, count);
        minMove = Math.max(minMove, idx);
    }
}