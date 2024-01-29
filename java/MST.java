import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1197- 최소 스패닝 트리
public class Main {
    static class Graph {
        int node;
        int weight;

        public Graph(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static ArrayList<Graph>[] lists;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        lists = new ArrayList[v + 1]; //트리 리스트 저장
        visit = new boolean[v + 1]; //방문 확인

        for (int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Graph(b, c));
            lists[b].add(new Graph(a, c)); //무방향 트리 이므로 양방향 저장
        }
        //가중치 오름차순 정렬 -> 최소 신장 트리를 구하기 위함
        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt((o -> o.weight)));
        queue.add(new Graph(1, 0));

        while (!queue.isEmpty()) {
            Graph current = queue.poll();

            int node = current.node;
            int cost = current.weight;

            if (!visit[node]) {
                visit[node] = true;
                min += cost; //가중치 갱신
            }

            for (Graph next : lists[node]) {
                if (!visit[next.node]) {
                    queue.add(next);
                }
            }
        }
        System.out.println(min);
    }
}
