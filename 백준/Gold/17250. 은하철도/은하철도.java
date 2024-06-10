import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17250 은하철도
public class Main {
    static int n, m;
    static int[] parents;
    static int[] count;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        count = new int[n + 1]; //이용할 수 있는 행성의 수
        size = new int[n + 1];  //철도가 연결될 때마다 이용할 수 있는 행성의 수
        for (int i = 1; i <= n; i++) {
            size[i] = count[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= m; k++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
            sb.append(size[find(v)]).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parents[b] = a;
                size[a] += size[b];
            } else {
                parents[a] = b;
                size[b] += size[a];
            }
        }
    }
}