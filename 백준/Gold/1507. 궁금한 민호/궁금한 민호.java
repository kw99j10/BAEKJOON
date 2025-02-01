import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1507 궁금한 민호
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[n + 1][n + 1]; // 방문할 최소 경로
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit[i], true);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (k == i || k == j || i == j) {
                        continue;
                    }

                    if (city[i][j] > city[i][k] + city[k][j]) {
                        System.out.println(-1); // 입력한 시간이 최소 시간이 아닌 경우
                        return;
                    }

                    // 불필요한 경로
                    if (city[i][j] == city[i][k] + city[k][j]) {
                        visit[i][j] = false;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (visit[i][j]) {
                    sum += city[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}