import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 28118 안전한 건설 계획
public class Main {
    static int n, m;
    static int[] gun;
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
        gun = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int min = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (find(i) != find(j)) {
                    union(i, j);
                    min++;
                }
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