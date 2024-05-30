import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6156 Cow Contest
public class Main {
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cow = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cow[i], INF);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cow[a][b] = 1; //a가 이김
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    cow[i][j] = Math.min(cow[i][j], cow[i][k] + cow[k][j]);
                }
            }
        }

        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cow[i][j] != INF || cow[j][i] != INF) {
                    count[i]++;
                }
            }
        }
        int know = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                know++;
            }
        }
        System.out.println(know);
    }
}