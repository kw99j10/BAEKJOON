import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 11780 플로이드 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int max = 100000001; //최대 비용 설정
        int[][] city = new int[n + 1][n + 1];
        int[][] road = new int[n + 1][n + 1]; // 도시가 가진 경로
        for (int i = 1; i <= n; i++) {
            Arrays.fill(city[i], max);
        }

        for (int i = 1; i <= n; i++) {
            city[i][i] = 0; // 자기 자신 도시
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            city[a][b] = Math.min(city[a][b], c);
            road[a][b] = a;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (city[i][j] > city[i][k] + city[k][j]) {
                        city[i][j] = city[i][k] + city[k][j];
                        road[i][j] = road[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == max) {
                    city[i][j] = 0;
                }
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        Stack<Integer> before; // 연결된 도시의 개수
        // 최소 비용 도시의 개수와 경로
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                before = new Stack<>();

                // 갈 수 없는 경로
                if (i == j || city[i][j] == 0) {
                    sb.append(0).append('\n');
                } else {
                    int k = j;

                    // 이전 경로 복원
                    while (k != i) {
                        before.push(road[i][k]);
                        k = road[i][k];
                    }
                    sb.append(before.size() + 1).append(" ");
                    while (!before.isEmpty()) {
                        sb.append(before.pop()).append(" ");
                    }
                    sb.append(j).append(" ");
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}