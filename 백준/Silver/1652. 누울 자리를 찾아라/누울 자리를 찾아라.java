import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1652 누울 자리를 찾아라
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int tmp1 = 0;
            int tmp2 = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    tmp1 = 0;
                    continue;
                }
                tmp1++;
                if (tmp1 == 2) {
                    cnt1++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (map[j][i] == 'X') {
                    tmp2 = 0;
                    continue;
                }
                tmp2++;
                if (tmp2 == 2) {
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }
}
