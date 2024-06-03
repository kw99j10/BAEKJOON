import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 24391 귀찮은 해강이
public class Main {
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

        //연결된 건물
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parents[find(a)], parents[find(b)]);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());

            if (parents[find(start)] != parents[find(next)]) {
                count++;
            }
            start = next;
        }
        System.out.println(count);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a >= b) {
            parents[a] = b;
        } else {
            parents[b] = a;
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