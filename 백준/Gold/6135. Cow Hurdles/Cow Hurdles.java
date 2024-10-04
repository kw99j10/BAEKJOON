import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//6135 Cow Hurdles
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] room = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(room[i], 999999);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int answer = Integer.parseInt(st.nextToken());
            room[x][y] = Math.min(room[x][y], answer);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (room[i][k] != 999999 && room[k][j] != 999999) {
                        room[i][j] = Math.min(room[i][j], Math.max(room[i][k], room[k][j]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            if (room[x][y] != 999999) {
                sb.append(room[x][y]);
            }else{
                sb.append(-1);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}