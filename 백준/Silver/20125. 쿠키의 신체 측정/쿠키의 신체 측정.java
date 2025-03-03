import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20125 쿠키의 신체 측정
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];

        // 쿠키 머리, 심장은 크기가 1
        int x = 0, y = 0; // 심장 좌표
        int lA = 0, rA = 0, w = 0, lL = 0, rL = 0; // 좌우 팔, 허리, 좌우 다리 길이

        boolean isCheck = false;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
                if (!isCheck && grid[i][j] == '*') {
                    x = i + 1;
                    y = j;
                    isCheck = true; // 심장 좌표
                }
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (grid[x][i] != '*') {
                break;
            }
            lA++;
        }

        for (int i = y + 1; i < n; i++) {
            if (grid[x][i] != '*') {
                break;
            }
            rA++;
        }

        for (int i = x + 1; i < n; i++) {
            if (grid[i][y] != '*') {
                break;
            }
            w++;
        }

        for (int i = x + w + 1; i < n; i++) {
            if (grid[i][y - 1] != '*') {
                break;
            }
            lL++;
        }

        for (int i = x + w + 1; i < n; i++) {
            if (grid[i][y + 1] != '*') {
                break;
            }
            rL++;
        }

        System.out.println((x + 1) + " " + (y + 1));
        System.out.println(lA + " " + rA + " " + w + " " + lL + " " + rL);
    }
}