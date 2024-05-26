import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17182 우주 탐사선
public class Main {
    static int n, k, min = Integer.MAX_VALUE;
    static int[][] time;
    static boolean[] isSelected;
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) + 1;

        time = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(time[i], INF);
            time[i][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                time[i][j] = Math.min(time[i][j], Integer.parseInt(st.nextToken()));
            }
        }

        // 행성 간 최소 이동거리 -> 플로이드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
                }
            }
        }

        // 모든 행성을 탐사 -> 백트래킹
        isSelected = new boolean[n + 1];
        isSelected[k] = true;
        backtracking(k, 1, 0);
        System.out.println(min);
    }

    static void backtracking(int start, int count, int sum) {

        if (count == n) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                backtracking(i, count + 1, sum + time[start][i]);
                isSelected[i] = false;
            }
        }
    }
}