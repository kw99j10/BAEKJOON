import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] ban = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ban[a][b] = true;
            ban[b][a] = true;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (ban[i][j]) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (ban[j][k] || ban[i][k]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
