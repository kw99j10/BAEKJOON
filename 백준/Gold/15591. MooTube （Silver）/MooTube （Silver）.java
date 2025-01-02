import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 15591 MooTube
public class Main {
    static int n, q, count;

    static class Usado implements Comparable<Usado> {
        int p, r;

        public Usado(int p, int r) {
            this.p = p;
            this.r = r;
        }

        @Override
        public int compareTo(Usado o) {
            return this.r - o.r;
        }
    }

    static ArrayList<Usado>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lists[s].add(new Usado(e, v)); // s -> e 까지 r의 경로
            lists[e].add(new Usado(s, v));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 동영상 v를 보고 있는 소들에게 k에 대한 추천 영상의 개수
            bfs(v, k);
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int s, int k) {
        count = 0;
        PriorityQueue<Usado> queue = new PriorityQueue<>();
        queue.add(new Usado(s, Integer.MAX_VALUE));

        boolean[] visit = new boolean[n + 1];
        visit[s] = true;

        while (!queue.isEmpty()) {
            Usado current = queue.poll();
            int node = current.p;
            int road = current.r;

            for (Usado next : lists[node]) {
                if (visit[next.p]) {
                    continue;
                }
                int min = Math.min(road, next.r);
                count = min >= k ? count + 1 : count;
                visit[next.p] = true;
                queue.add(new Usado(next.p, min));
            }
        }
    }
}
