import java.util.*;

public class Main {
    static class Node {
        int v; //목적지 노드
        int cost; //목적지 노드 까지 걸리는 비용(가중치)

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] lists; //노드 정보를 담을 리스트
    static int[] distance; //노드 간 최단 거리를 담는 배열
    static boolean[] visit; //방문 확인 배열
    static int n;
    static int INF = 80000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //정점의 개수
        int e = sc.nextInt(); //간선의 개수

        //노드 리스트 선언 및 초기화
        lists = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c)); //양방향 간선
        }
        //반드시 거쳐야 하는 정점 v1,v2
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        //정점 (v1,v2)을 거치는 경우의 수
        //1. ... -> v1 -> v2 -> ...
        int distance1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);

        //2. ... -> v2 -> v1 -> ...
        int distance2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int min = Math.min(distance1, distance2);
        min = min >= INF ? -1 : min;
        System.out.println(min);
    }

    private static int dijkstra(int start, int end) {

        //최단 거리를 구하기 위함 & 중복 방지
        PriorityQueue<Node> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));

        distance = new int[n + 1];
        visit = new boolean[n + 1];

        //거리 & 방문 배열 초기화
        Arrays.fill(distance, INF);
        Arrays.fill(visit,false);

        //시작 점 초기화
        queue.add(new Node(start, 0));
        visit[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node list : lists[node.v]) {
                if (distance[list.v] > node.cost + list.cost) {
                    distance[list.v] = node.cost + list.cost;
                    queue.add(new Node(list.v, distance[list.v]));
                }
            }
        }
        return distance[end];
    }
}
