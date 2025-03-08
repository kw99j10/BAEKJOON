import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11085 군사 이동
public class Main {
    static int p;
    static int[] parents;

    static class Road implements Comparable<Road> {
        int go, target, width;

        public Road(int go, int target, int width) {
            this.go = go;
            this.target = target;
            this.width = width;
        }

        @Override
        public int compareTo(Road o) {
            return o.width - this.width; // 너비를 최대화
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        parents = new int[p];
        for (int i = 0; i < p; i++) {
            parents[i] = i;
        }

        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // Baekjoon 수도 c
        int v = Integer.parseInt(st.nextToken()); // Cube Word 수도 v

        PriorityQueue<Road> queue = new PriorityQueue<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            queue.add(new Road(start, end, width));
        }

        while (!queue.isEmpty()) {
            Road current = queue.poll();
            int start = current.go;
            int end = current.target;
            union(start, end);

            if (find(c) == find(v)) {
                System.out.println(current.width);
                return;
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }
}