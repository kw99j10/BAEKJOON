import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node {
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] arr; //노드의 정보를 담을 list
    static boolean[] visit; //방문 정보를 담을 배열
    static int[] distance; //최소 거리를 담을 배열
    static int start; //출발 도시
    static int end;  //도착 도시

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //도시의 개수
        int m = sc.nextInt(); //버스의 개수

        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        distance = new int[n + 1];

        //다익스트라 배열 초기화
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        //버스의 정보
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt(); //시작 도시
            int end = sc.nextInt(); //도착 도시
            int cost = sc.nextInt(); //비용

            arr[start].add(new Node(end, cost));
        }
        start = sc.nextInt();
        end = sc.nextInt();

        dijkstra(start); //출발 지점 부터 다익스트라 시작
    }

    private static void dijkstra(int start) {
        //우선순위 큐 사용: 비용 순으로 오름차순 정렬, 중복 값 방지
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        //시작점 초기화
        visit[start] = true;
        distance[start] = 0;
        queue.add(new Node(start, 0));


        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //도착 노드에 도달했다면 다익스트라를 종료
            if (node.v == end) {
                System.out.println(node.cost);
                break;
            }

            //아직 방문하지 않은 노드라면 방문
            if (!visit[node.v]) {
                visit[node.v] = true;
            }

            //현재 노드 기준으로 이어진 노드들에 대하여 for문 실행, list : 이어진 노드
            for (Node list : arr[node.v]) {
                //이어진 노드가 방문한 곳이 아니고 거리가 초기화되지 않았을 경우 갱신
                if (!visit[list.v] && distance[list.v] > node.cost + list.cost) {
                    distance[list.v] = node.cost + list.cost;
                    queue.add(new Node(list.v, distance[list.v]));
                }
            }
        }
    }
}
