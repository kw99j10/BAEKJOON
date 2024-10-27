import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10971 외판원 순회 2
public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] circle;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        circle = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            backtracking(i, i, 0, 0); //idx, start, count, 비용
            visit[i] = false;
        }
        System.out.println(min);
    }

    static void backtracking(int idx, int start, int cnt, int cost) {
        if (cnt == n - 1) {
            if (circle[start][idx] == 0) {
                return;
            }
            cost += circle[start][idx];
            min = Math.min(min, cost);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] || circle[start][i] == 0) {
                continue;
            }
            visit[i] = true;
            backtracking(idx, i, cnt + 1, cost + circle[start][i]); //시작지점 변경
            visit[i] = false;
        }
    }
}