import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//선 긋기 
public class Main {
    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x; //x좌표 기준 오름차순 정렬 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new Node(a, b));
        }
        Node cur= queue.poll();
        int pre_x = cur.x;
        int pre_y = cur.y;
        long sum = pre_y - pre_x;

        //이전좌표, 현재 좌표를 비교한 스위핑 반복
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cur_x = current.x;
            int cur_y = current.y;

            if (cur_x >= pre_x && pre_y >= cur_y) {
                continue;
            }
            sum += pre_y > cur_x ? cur_y - pre_y : cur_y - cur_x;
            pre_x = cur_x;
            pre_y = cur_y; 
        }
        System.out.println(sum);
    }
}
