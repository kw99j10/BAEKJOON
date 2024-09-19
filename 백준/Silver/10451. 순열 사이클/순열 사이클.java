import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10451 순열 사이클
public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int k = Integer.parseInt(st.nextToken());
                if (find(i) == find(k)) {
                    cnt++;
                }else{
                    union(i, k);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
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
    static int find(int a) {
        if (a == parents[a]) {
            return a;
        }else{
            return parents[a] = find(parents[a]);
        }
    }
}