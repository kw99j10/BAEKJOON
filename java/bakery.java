import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빵집
public class Main {
    static int r, c;
    static char[][] house;
    static int[] dir = {-1, 0, 1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new char[r][c];
        for (int i = 0; i < r; i++) {
            house[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            if (dfs(i, 0)) {
                count += 1; //1열에 대해서만 필요
            }
        }
        System.out.println(count);
    }

    static boolean dfs(int x, int y) {

        if (y == c - 1) {
            return true; // 파이프라인은 마지막 열(빵집)에서 끝나야 함
        }

        if (house[x][y] == '.') {
            house[x][y] = 'p'; //파이프 표시
            for (int i = 0; i < 3; i++) {
                int nx = x + dir[i];
                int ny = y + 1;

                if (nx >= 0 && nx < r && ny < c && house[nx][ny] == '.') {
                    if (dfs(nx, ny)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
