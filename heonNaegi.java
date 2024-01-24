import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//헌내기는 친구가 필요해
public class Main {
    static int n, m;
    static char[][] cam;
    static boolean[][] visit;
    static LinkedList<int[]> queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cam = new char[n][m];
        visit = new boolean[n][m];
        queue = new LinkedList<>();

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < m; j++) {
                cam[i][j] = tmp.charAt(j);
                if (cam[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        int count = friendCount(startX, startY);
        System.out.println(count == 0 ? "TT" : count);
    }

    private static int friendCount(int startX, int startY) {
        int count = 0;

        visit[startX][startY] = true;
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visit[nx][ny]) {
                        if (cam[nx][ny] == 'P') {
                            count += 1;
                            visit[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                        else if (cam[nx][ny] == 'O') {
                            visit[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return count;
    }
}
