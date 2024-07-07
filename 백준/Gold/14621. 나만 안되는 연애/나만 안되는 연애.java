import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나만 안되는 연애
public class Main {
    static class Info implements Comparable<Info> {
       int node;
       int weight;

        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }

    static String[] gender;
    static ArrayList<Info>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        gender = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            gender[i] = st.nextToken();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lists[u].add(new Info(v, d));
            lists[v].add(new Info(u, d));
        }
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Info> queue = new PriorityQueue<>();
        int sum = 0;
        queue.add(new Info(1, 0));
        while (!queue.isEmpty()) {
            Info current = queue.poll();
            int node = current.node;
            int cost = current.weight;

            if (!visit[node]) {
                visit[node] = true;
                sum += cost;
            }

            for (Info next : lists[node]) {
                if (!visit[next.node] && !gender[node].equals(gender[next.node])) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                sum = -1; //모든 학교를 연결하지 못 함
                break;
            }
        }
        System.out.println(sum);
    }
}