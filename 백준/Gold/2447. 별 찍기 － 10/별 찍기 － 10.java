import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2447 별찍기-10
public class Main {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        star = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }
        divide(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void divide(int x, int y, int size) {

        if (size == 1) {
            star[x][y] = '*';
            return;
        }

        divide(x, y, size / 3);
        divide(x, y + size / 3, size / 3);
        divide(x, y + 2 * size / 3, size / 3);

        divide(x + size / 3, y, size / 3);
        //가운데 공백 
        // divide(x + size / 3, y + size / 3, size / 3);
        divide(x + size / 3, y + 2 * size / 3, size / 3);

        divide(x + 2 * size / 3, y, size / 3);
        divide(x + 2 * size / 3, y + size / 3, size / 3);
        divide(x + 2 * size / 3, y + 2 * size / 3, size / 3);
    }
}