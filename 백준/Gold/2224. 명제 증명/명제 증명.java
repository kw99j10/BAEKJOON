import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2224 명제 증명
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] alpha = new int[52][52];
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i != j) {
                    alpha[i][j] = 10001; // 알파벳 명제
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int a = s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' ? (int) s.charAt(0) - 65 : (int) s.charAt(0) - 71;
            int b = s.charAt(5) >= 'A' && s.charAt(5) <= 'Z' ? (int) s.charAt(5) - 65 : (int) s.charAt(5) - 71;
            alpha[a][b] = 1;
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    alpha[i][j] = Math.min(alpha[i][j], alpha[i][k] + alpha[k][j]);
                }
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i != j && alpha[i][j] != 10001) {
                    char a = (i < 26) ? (char) (i + 65) : (char) (i + 71);
                    char b = (j < 26) ? (char) (j + 65) : (char) (j + 71);
                    sb.append(a).append(" => ").append(b).append("\n");
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }
}