import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1689 겹치는 선분
public class Main {
    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<Node> lists = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists.add(new Node(x, y));
        }

        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (!lists.isEmpty()) {
            Node current = lists.poll();
            int x = current.x;
            int y = current.y;

            // 겹치지 않는 선분 제거 ex) (queue.peek == 7, x == 8)
            while (!queue.isEmpty() && x >= queue.peek()) {
                queue.poll();
            }
            queue.add(y);
            cnt = Math.max(cnt, queue.size());
        }
        System.out.println(cnt);
    }
}