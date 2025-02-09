import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16168 퍼레이드
class Main {
    static int v, e;
    static int[] parents;
    static int[] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        grid = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int va = Integer.parseInt(st.nextToken());
            int vb = Integer.parseInt(st.nextToken());

            if (find(va) != find(vb)) {
                union(va, vb);
            }
            grid[va]++;
            grid[vb]++;
        }

        // 모든 정점 연결 판단 (홀수 차수 정점이 0개 or 2개)
        int cnt = 0;
        boolean isPossible = true;
        for (int i = 1; i <= v; i++) {
            if (grid[i] > 0 && find(i) != find(1)) {
                isPossible = false; // 적어도 하나 이상 연결 & 다른 집합의 경우
            }
            if (grid[i] % 2 == 1) {
                cnt++;
            }
        }
        System.out.println(((cnt == 0 || cnt == 2) && isPossible) ? "YES" : "NO");
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