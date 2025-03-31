import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 13418 학교 탐방하기
public class Main {
    static class Graph {
        int start, end, cost;

        public Graph(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int[] parents;
    static ArrayList<Graph> lists;
    static int n, m, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Graph> minQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        PriorityQueue<Graph> maxQ = new PriorityQueue<>((a, b) -> b.cost - a.cost);
        lists = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 0: 오르막길, 1: 내리막길
            minQ.add(new Graph(a, b, c));
            maxQ.add(new Graph(a, b, c));
        }

        while (!minQ.isEmpty()) {
            Graph current = minQ.poll();
            if (find(current.start) != find(current.end)) {
                union(current.start, current.end);
                if (current.cost == 0) {
                    min++;
                }
            }
        }

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        while (!maxQ.isEmpty()) {
            Graph current = maxQ.poll();
            if (find(current.start) != find(current.end)) {
                union(current.start, current.end);
                if (current.cost == 0) {
                    max++;
                }
            }
        }
        System.out.println(min * min - max * max);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents[b] = a;
        } else{
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