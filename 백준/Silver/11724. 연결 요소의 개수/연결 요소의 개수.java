import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724 연결 요소의 개수
public class Main {
    static int[][] arr;
    static int m, n;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        visit = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int x) {
        visit[x] = true;
        for (int i = 0; i < n; i++) {
            if (!visit[i] && arr[x][i] == 1) {
                dfs(i);
            }
        }
    }
}