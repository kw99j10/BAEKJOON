import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10971 외판원 순회 2
public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] w;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n];
        visit[0] = true;
        tsm(0, 0, 0, 0); //한 번의 순회로 최소 비용을 얻을 수 있음
        System.out.println(min);
    }

    static void tsm(int idx, int start, int cnt, int sum) {
        if (cnt == n - 1 && w[start][idx] != 0) {
            sum += w[start][idx];
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] || w[start][i] == 0) {
                continue;
            }
            visit[i] = true;
            tsm(idx , i, cnt + 1, sum + w[start][i]);
            visit[i] = false;
        }
    }
}