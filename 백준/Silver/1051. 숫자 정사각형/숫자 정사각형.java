import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1051 숫자 정사각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                square[i][j] = s.charAt(j) - '0';
            }
        }

        if (n == 1 || m == 1) {
            System.out.println(1);
            return;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = 1;
                while (n - i > k && m - j > k) {
                    if (square[i][j] == square[i][j + k] && square[i][j] == square[i + k][j]
                            && square[i][j] == square[i + k][j + k]) {
                        max = Math.max(max, (k + 1) * (k + 1));
                    }
                    k++;
                }
            }
        }
        System.out.println(max);
    }
}