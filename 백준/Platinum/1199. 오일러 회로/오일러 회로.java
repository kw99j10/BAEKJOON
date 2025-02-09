import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1199 오일러 회로
class Main {
    static int n;
    static int[][] grid;
    static ArrayList<Integer> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                cnt += grid[i][j];
            }
            if (cnt % 2 != 0) {
                System.out.println(-1); // 회로가 만들어지지 않음
                return;
            }
        }

        lists = new ArrayList<>(); // 한번에 뒤집어서 출력 => 재귀 순서 중요
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = lists.size() - 1; i >= 0; i--) {
            sb.append(lists.get(i)).append(" ");
        }
        System.out.print(sb);
    }

    static void dfs(int x) {
        for (int i = 1; i <= n; i++) {
            while (grid[x][i] > 0) {
                grid[i][x]--;
                grid[x][i]--;
                dfs(i);
            }
        }
        lists.add(x);
    }
}