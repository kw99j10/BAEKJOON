import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7682 틱택토
public class Main {
    static char[][] grid; //게임판
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            grid = new char[3][3];
            for (int i = 0; i < 9; i++) {
                grid[i / 3][i % 3] = s.charAt(i);
            }
            if (tictacto()) {
                sb.append("valid").append("\n");
            }else{
                sb.append("invalid").append("\n");
            }
        }
        System.out.print(sb);
    }
    static boolean tictacto() {

        int xCnt = 0; // 첫 번째 사람
        int oCnt = 0; // 두 번째 사람
        int blank = 0; // 빈칸

        // 연속한 3칸 개수
        int xLine = 0;
        int oLine = 0;

        for (int i = 0; i < 9; i++) {
            if (grid[i / 3][i % 3] == 'X') {
                xCnt++;
            }else if (grid[i / 3][i % 3] == 'O'){
                oCnt++;
            }else{
                blank++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X') {
                xLine++;
            }
            if (grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X') {
                xLine++;
            }

            if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O') {
                oLine++;
            }
            if (grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O') {
                oLine++;
            }
        }

        //대각선 카운팅
        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            xLine++;
        }
        if (grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X') {
            xLine++;
        }

        if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            oLine++;
        }
        if (grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O') {
            oLine++;
        }

        // 불가능한 경우의 수

        // 1. 빈칸이 있는데 틱택토가 없는 경우
        if (blank != 0 && (xLine == 0 && oLine == 0)) {
            return false;
        }

        // 2. x보다 o가 더 많은 경우
        if (oCnt > xCnt) {
            return false;
        }

        // 3. x가 o+1보다 큰 경우
        if (xCnt > oCnt + 1) {
            return false;
        }

        // 4. 동시에 이길 수 없음
        if (xLine > 0 && oLine > 0) {
            return false;
        }

        // 5. x가 이긴 경우 x=o+1 여야 함
        if (xLine > 0 && xCnt != oCnt + 1) {
            return false;
        }

        // 6. o가 이긴 경우 x=o 여야 함
        if (oLine > 0 && xCnt != oCnt) {
            return false;
        }

        // 7. 비긴 경우 x=o+1 여야 함
        if ((xLine == 0 && oLine == 0) && (xCnt != oCnt + 1)) {
            return false;
        }

        return true;
    }
}