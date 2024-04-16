import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//구슬 찾기
public class Main {
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] bead = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(bead[i], INF); //구슬 비교 위해 배열 초기화
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bead[a][b] = 1; //a 구슬이 b 구슬보다 무거움
        }

        //플로이드 워셜을 통해 크기 비교
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    bead[i][j] = Math.min(bead[i][j], bead[i][k] + bead[k][j]);
                }
            }
        }
        int count = 0; //중간이 될 수 없는 구슬의 수
        for (int i = 1; i <= n; i++) {
            int heavy = 0; //현재 구슬보다 무거운 구슬의 개수
            int light = 0; //가벼운 구슬의 개수

            for (int j = 1; j <= n; j++) {
                if (bead[i][j] != INF) {
                    heavy++;
                } else if (bead[j][i] != INF) {
                    light++;
                }
            }
            if (heavy >= (n + 1) / 2 || light >= (n + 1) / 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
