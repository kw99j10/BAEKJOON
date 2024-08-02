import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 27498 연애 혁명
public class Main {
    static class Students implements Comparable<Students> {
        int x, y, love;
        public Students(int x, int y, int love) {
            this.x = x;
            this.y = y;
            this.love = love;
        }

        @Override
        public int compareTo(Students o) {
            return o.love - this.love;
        }
    }
    static int n, m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Students> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (d == 1) {
                union(a, b);
            }
            else{
                queue.add(new Students(a, b, c));
            }
        }
        int min = 0;
        while (!queue.isEmpty()) {
            Students current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (find(x) != find(y)) {
                union(x, y);
            }
            else{
                min += current.love;
            }
        }
        System.out.println(min);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents[b] = a;
        }
        else{
            parents[a] = b;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        else {
            return parents[x] = find(parents[x]);
        }
    }
}