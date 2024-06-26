import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1774 우주신과의 교감
public class Main {
    static class Road {
        double x;
        double y;
        double length;

        public Road(double x, double y, double length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    static int n, m;
    static int[] parents;
    static double[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Road> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.length));
        grid = new double[n + 1][2]; //x,y 좌표
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            grid[i][0] = x;
            grid[i][1] = y;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                queue.add(new Road(i, j, getDistance(i, j)));
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        double min = 0.0;
        while (!queue.isEmpty()) {
            Road current = queue.poll();
            int a = (int) current.x;
            int b = (int) current.y;
            double length = current.length;

            if (find(a) != find(b)) {
                union(a, b);
                min += length;
            }
        }
        System.out.printf("%.2f", min); // 소수점 둘째 자리 반올림
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

    static double getDistance(int i, int j) {
        double x1 = grid[i][0];
        double y1 = grid[i][1];
        double x2 = grid[j][0];
        double y2 = grid[j][1];
        return Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
    }
}