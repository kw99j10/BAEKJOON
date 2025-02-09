import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18250 철도 여행
class Main {
    static int n, m;
    static int[] travel;
    static int[] parents;
    static boolean[] visit;
    static int[] road = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        travel = new int[n + 1];

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                union(a, b);
            }
            travel[a]++;
            travel[b]++;
        }

        // 경로 노드 조건 => 홀수 차수
        for (int i = 1; i <= n; i++) {
            if (travel[i] % 2 != 0) {
                road[find(i)]++;
            }
        }

//        for (int i = 1; i <= n; i++) {
//            System.out.print(road[i] + " ");
//        }
//        System.out.println();

        visit = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            if (travel[i] == 0) {
                continue; // 철도가 없으면 방문하지 않음
            }

            if (!visit[find(i)]) {
                visit[find(i)] = true;
                cnt += Math.max(road[find(i)] / 2, 1); // 경로 2개당 하나의 철도 노선이 필요
            }
        }
        System.out.println(cnt);
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