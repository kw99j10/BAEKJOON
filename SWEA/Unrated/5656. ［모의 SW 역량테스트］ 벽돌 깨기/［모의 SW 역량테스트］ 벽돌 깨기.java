import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Solution {
    static int n, w, h, answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = Integer.MAX_VALUE;
            dfs(0, map);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int count, int[][] arr) {

        if (answer == 0) {
            return;
        }
        
        if (getCount(arr) == 0) {
            answer = 0; //현재 벽돌의 개수가 0이면 종료
            return;
        }

        if (count == n) {
            answer = Math.min(answer, getCount(arr));
            return;
        }

        for (int i = 0; i < w; i++) {
            visit = new boolean[h][w];
            int[][] tmp = copyArray(arr);
            boolean flag = false;

            for (int j = 0; j < h; j++) {
                if (arr[j][i] > 0) {
                    remove(arr, j, i, tmp);
                    down(tmp);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                dfs(count + 1, tmp);
            }
        }
    }

    static void remove(int[][] arr, int x, int y, int[][] tmp) {
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < arr[x][y]; i++) {
                int nx = x + dx[d] * i; //num-1까지 벽돌을 부숨
                int ny = y + dy[d] * i;

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;

                if (arr[nx][ny] > 0) {
                    tmp[nx][ny] = 0;
                    remove(arr, nx, ny, tmp);
                }
            }
        }
    }

    //배열 아래로 이동
    static void down(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < w; j++) {
            for (int i = 0; i < h; i++) {
                if (arr[i][j] > 0) {
                    stack.push(arr[i][j]);
                }
                arr[i][j] = 0;
            }

            int idx = h - 1;
            while (!stack.isEmpty()) {
                arr[idx][j] = stack.pop();
                idx--;
            }
        }
    }

    static int[][] copyArray(int[][] arr) {
        int[][] tmp = new int[h][w];
        for (int i = 0; i < h; i++) {
            if (w >= 0) System.arraycopy(arr[i], 0, tmp[i], 0, w);
        }
        return tmp;
    }

    static int getCount(int[][] arr) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}