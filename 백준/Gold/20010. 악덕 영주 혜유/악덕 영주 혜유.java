import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 20010 악덕 영주 혜유
public class Main {
    static class Graph {
        int start, end, cost;

        public Graph(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int[] parents;
    static ArrayList<Graph> lists;
    static int n, m, max, maxIndex;
    static ArrayList<Node>[] tree;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        lists = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Graph(a, b, c));
        }

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        long total = 0L;
        while (!queue.isEmpty()) {
            Graph current = queue.poll();
            if (find(current.start) != find(current.end)) {
                union(current.start, current.end);
                total += current.cost;
                tree[current.start].add(new Node(current.end, current.cost));
                tree[current.end].add(new Node(current.start, current.cost));
            }
        }

        // 마을과 마을을 이동하는 가장 최악의 비용 => 트리에서 가장 긴 경로의 길이
        visit = new boolean[n + 1];
        visit[0] = true;
        dfs(0, 0);

        visit = new boolean[n + 1];
        visit[maxIndex] = true;
        dfs(maxIndex, 0);

        System.out.println(total);
        System.out.println(max);
    }

    static void dfs(int current, int distance) {
        for (Node next : tree[current]) {
            if (!visit[next.node]) {
                visit[next.node] = true;
                dfs(next.node, distance + next.weight);
            }

            if (distance > max) {
                max = distance;
                maxIndex = current;
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