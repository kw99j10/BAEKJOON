import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2887 행성 터널
public class Main {
    static class Planet {
        int x, y, z, num;

        public Planet(int x, int y, int z, int num) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    static class Node implements Comparable<Node> {
        int start, end, cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] parents;
    static PriorityQueue<Node> queue; // 터널 연결 정보
    static ArrayList<Planet> planets; // 행성 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        planets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(x, y, z, i));
        }

        queue = new PriorityQueue<>();

        // x축, y축, z축 차례로 정렬하여 탐색 최소화
        planets.sort(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < n - 1; i++) {
            int x1 = planets.get(i).num;
            int x2 = planets.get(i + 1).num;
            queue.add(new Node(x1, x2, Math.abs(planets.get(i).x - planets.get(i + 1).x)));
        }

        planets.sort(Comparator.comparingInt(o -> o.y));
        for (int i = 0; i < n - 1; i++) {
            int y1 = planets.get(i).num;
            int y2 = planets.get(i + 1).num;
            queue.add(new Node(y1, y2, Math.abs(planets.get(i).y - planets.get(i + 1).y)));
        }

        planets.sort(Comparator.comparingInt(o -> o.z));
        for (int i = 0; i < n - 1; i++) {
            int z1 = planets.get(i).num;
            int z2 = planets.get(i + 1).num;
            queue.add(new Node(z1, z2, Math.abs(planets.get(i).z - planets.get(i + 1).z)));
        }

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int min = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.start;
            int y = current.end;
            if (find(x) != find(y)) {
                union(x, y);
                min += current.cost;
            }
        }
        System.out.println(min);
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