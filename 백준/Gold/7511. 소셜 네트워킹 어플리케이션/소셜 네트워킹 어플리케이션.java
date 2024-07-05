import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//7511 소셜 네트워킹 어플리케이션
public class Main {
    static int T, n;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            //유저의 수
            n = Integer.parseInt(br.readLine());
            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            //친구 관계
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            //구해야하는 쌍
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                sb.append(find(u) == find(v) ? 1 : 0).append("\n");
            }
            System.out.println("Scenario " + (t + 1) + ":");
            System.out.println(sb);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        }else{
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