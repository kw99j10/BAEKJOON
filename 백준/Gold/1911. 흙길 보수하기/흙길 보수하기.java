import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1911 흙길 보수하기
public class Main {
    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start, end));
        }

        long sum = 0L;

        int cx = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int s = current.start;
            int e = current.end;

            if (cx > s) {
                s = cx;
            }

            if (s >= e) {
                continue;
            }

            int len = ((e - s) + l - 1) / l;
            sum += len;
            cx = s + len * l; // 다음 위치 갱신
        }
        System.out.println(sum);
    }
}