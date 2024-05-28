import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16958 텔레포트
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] city = new int[n + 1][3]; //각 도시의 정보
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            city[i][0] = Integer.parseInt(st.nextToken()); //특별한 도시 여부
            city[i][1] = Integer.parseInt(st.nextToken()); //x좌표
            city[i][2] = Integer.parseInt(st.nextToken()); //y좌표
        }

        int[][] time = new int[n + 1][n + 1]; //도시 간 거리
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                time[i][j] = time[j][i] = Math.abs(city[i][1] - city[j][1]) + Math.abs(city[i][2] - city[j][2]);

                //두 도시가 모두 특별한 도시의 경우
                if (city[i][0] == 1 && city[j][0] == 1) {
                    if (time[i][j] > t) {
                        time[i][j] = time[j][i] = t;
                    }
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(time[a][b]).append("\n");
        }
        System.out.print(sb);
    }
}