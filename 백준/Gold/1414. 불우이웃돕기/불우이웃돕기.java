import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1414 불우이웃돕기
public class Main {
    static class Alpha implements Comparable<Alpha> {
        int start;
        int end;
        int weight;

        public Alpha(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Alpha o) {
            return this.weight - o.weight;
        }
    }

    static int n;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        parents = new int[n];

        int total = 0; //총 랜선 길이
        PriorityQueue<Alpha> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int count;
                if (c == '0') {
                    continue;
                } else if (c >= 'a' && c <= 'z') {
                    count = c - 'a' + 1;
                } else {
                    count = c - 'A' + 27;
                }
                queue.add(new Alpha(i, j, count));
                total += count;
            }
            parents[i] = i;
        }

        int cnt = 0; // 랜선 묶음 개수
        int max = 0; // mst
        while (!queue.isEmpty()) {
            Alpha current = queue.poll();
            int start = current.start;
            int end = current.end;

            if (find(start) != find(end)) {
                max += current.weight;
                union(start, end);
                cnt++;
            }
        }
        System.out.println(cnt == n - 1 ? total - max : -1);
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