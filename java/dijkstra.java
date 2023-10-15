import java.util.*;

// 최단 경로- 다익스트라
public class dijkstra {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] list;
    static boolean[] visit;
    static int[] distance;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        list = new ArrayList[V + 1];
        visit = new boolean[V + 1];
        distance = new int[V + 1];

        //list 빈 리스트 초기화, 거리 최대 값으로 초기화
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            //u에서 v로 가는 가중치 w

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
        }
        dijkstra(K);

        //거리 값이 최대 값이면 경로가 없는 경우이므로 INF 출력
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF");
        }
    }

    static void dijkstra(int k) {
        //가중치 오름차순 정렬
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        //시작 점(K) 초기화
        queue.add(new Node(k, 0));
        visit[k] = true;
        distance[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //해당 노드의 정점을 방문하지 않았다면 방문(true)
            if (!visit[node.v]) {
                visit[node.v] = true;
            }
            for (Node next : list[node.v]) {
                if (!visit[next.v] && distance[next.v] > next.cost + node.cost) {
                    distance[next.v] = next.cost + node.cost; //최단 경로 초기화
                    queue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}
