import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//드래곤 커브
public class Main {
    static int[][] grid;
    static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new int[101][101]; //격자 크기
        int n = Integer.parseInt(br.readLine());

        //시작점(x,y), 시작 방향, 세대(시계방향 90도 회전)
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(y, x, d, g);
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (grid[i][j] == 1 && grid[i][j + 1] == 1
                        && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void dragonCurve(int x, int y, int d, int g) {
        grid[x][y] = 1;

        ArrayList<Integer> dir = new ArrayList<>();
        dir.add(d);

        for (int i = 1; i <= g; i++) {
            int size = dir.size();
            for (int j = 0; j < size; j++) {
                d = dir.get(size - j - 1) + 1 > 3 ? 0 : dir.get(size - j - 1) + 1;
                dir.add(d);
            }
        }

        for (Integer integer : dir) {
            x += move[integer][0];
            y += move[integer][1];
            grid[x][y] = 1;
        }
    }
}