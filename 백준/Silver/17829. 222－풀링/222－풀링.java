import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17829 222-풀링
public class Main {
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(divide(0, 0, n));
    }

    static int divide(int x, int y, int len) {

        if (len == 1) {
            return grid[x][y];
        }

        int[] arr = new int[4];
        arr[0] = divide(x, y, len / 2);
        arr[1] = divide(x + len / 2, y, len / 2);
        arr[2] = divide(x, y + len / 2, len / 2);
        arr[3] = divide(x + len / 2, y + len / 2, len / 2);
        Arrays.sort(arr);
        return arr[2];
    }
}