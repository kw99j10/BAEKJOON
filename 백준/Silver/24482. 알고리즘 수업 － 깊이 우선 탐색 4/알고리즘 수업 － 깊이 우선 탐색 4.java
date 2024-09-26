import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//24482 알고리즘 수업 - 깊이 우선 탐색 4
public class Main {
    static int n, m, count;
    static ArrayList<Integer>[] lists;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visit = new int[n + 1];
        Arrays.fill(visit, -1);
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lists[u].add(v);
            lists[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            lists[i].sort(((o1, o2) -> Integer.compare(o2, o1)));
        }
        dfs(r, 0);
        for (int i = 1; i <= n; i++) {
            System.out.println(visit[i]);
        }
    }

    static void dfs(int x, int h) {
        visit[x] = h;
        for (Integer i : lists[x]) {
            if (visit[i] == -1) {
                dfs(i, h + 1);
            }
        }
    }
}