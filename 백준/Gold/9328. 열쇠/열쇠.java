import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 9328 열쇠
public class Main {
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int h, w, max;
    static char[][] buildings;
    static ArrayList<Character> keys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            buildings = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    buildings[i][j] = s.charAt(j);
                }
            }

            keys = new ArrayList<>(); // 상근이가 갖고 있는 열쇠 리스트
            String s = br.readLine(); // "0"일 경우 열쇠 없음
            if (!s.equals("0")) {
                for (int i = 0; i < s.length(); i++) {
                    keys.add(s.charAt(i));
                }
            }

            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[h][w];
        max = 0;

        checkInput(queue, visit); // 상근이가 빌딩으로 들어갈 좌표 검사 (입구로 출입 가능)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            //안팎 여부 판단 후 이동
            // 방문 위치가
            // 1. 문서인 경우
            if (buildings[x][y] == '$') {
                max++;
                buildings[x][y] = '.';
            }

            // 2. 잠긴 문일 경우
            else if (buildings[x][y] >= 'A' && buildings[x][y] <= 'Z') {
                if (!keys.contains((char) (buildings[x][y] + 32))) {
                    continue;
                }
            }

            // 3. 열쇠일 경우
            else if (buildings[x][y] >= 'a' && buildings[x][y] <= 'z') {
                if (!keys.contains(buildings[x][y])) {
                    keys.add(buildings[x][y]);
                    queue.clear(); // 큐 초기화
                    visit = new boolean[h][w]; // 방문 초기화
                    checkInput(queue, visit);
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                // 벽인 경우 못 지나감
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny] || buildings[nx][ny] == '*') {
                    continue;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        return max;
    }

    static void checkInput(ArrayDeque<int[]> queue, boolean[][] visit) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i == 0 || j == 0 || i == h - 1 || j == w - 1) && (buildings[i][j] != '*')
                        && !(buildings[i][j] >= 'A' && buildings[i][j] <= 'Z'
                        && !keys.contains((char) (buildings[i][j] + 32)))) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
    }
}
