import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18243 Small World Network
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] network = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(network[i], 999999);
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][b] = network[b][a] = 1;
        }
        for (int i = 1; i <= n; i++) {
            network[i][i] = 0;
        }
        for (int s = 1; s <= n; s++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    network[i][j] = Math.min(network[i][j], network[i][s] + network[s][j]);
                }
            }
        }
        boolean isSmall = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (network[i][j] > 6) {
                    isSmall = false;
                    break;
                }
            }
        }
        System.out.println(isSmall ? "Small World!" : "Big World!");
    }
}