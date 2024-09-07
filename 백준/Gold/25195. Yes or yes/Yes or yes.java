import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 25195 Yes or yes
public class Main {
    static int n, m, s;
    static ArrayList<Integer>[] lists;
    static String answer = "Yes";
    static boolean[] visit; // 노드 방문 여부
    static boolean[] spot; // 팬클럽 곰곰이가 잠복한 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
        }

        visit = new boolean[n + 1];
        spot = new boolean[n + 1];
        s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); // 팬클럽 곰곰이가 있는 곳
        for (int i = 0; i < s; i++) {
            spot[Integer.parseInt(st.nextToken())] = true;
        }

        dfs(1, false);//시작 노드, 팬클럽 만남 여부
        System.out.println(answer);
    }

    static void dfs(int node, boolean meet) {

        if (visit[node]) {
            return;
        }
        visit[node] = true;

        if (spot[node]) {
            meet = true;
        }

        if (lists[node].isEmpty() && !meet) {
            answer = "yes";
            return;
        }

        for (Integer next : lists[node]) {
            if (!visit[next]) {
                dfs(next, meet);
            }
        }
        visit[node] = false; // 모든 경우의 수 탐색
    }
}