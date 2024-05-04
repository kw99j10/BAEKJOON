import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        int[][] info = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], time);
            dist[b][a] = Math.min(dist[b][a], time);
            info[a][b] = b;
            info[b][a] = a;
        }

        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }

        //길이가 같은 최단 경로의 경우 어떤 집하장을 통과하여도 상관 없음
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        info[i][j] = info[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (info[i][j] == 0) {
                    System.out.print('-' + " ");
                } else {
                    System.out.print(info[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}