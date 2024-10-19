import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 5107 마니또
public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i; // 사이클 여부 판단을 위한 분리 집합
            }

            int count = 0;
            int idx = 1; // giver와 taker에 대한 고유 번호
            HashMap<String, Integer> friends = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                String giver = s.split(" ")[0];
                String taker = s.split(" ")[1];

                if (!friends.containsKey(giver)) {
                    friends.put(giver, idx++);
                }

                if (!friends.containsKey(taker)) {
                    friends.put(taker, idx++);
                }

                int start = friends.get(giver);
                int end = friends.get(taker);
                if (find(start) != find(end)) {
                    union(start, end); // 연결고리 여부 판단
                }else{
                    count++;
                }
            }
            sb.append(test++).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
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
    static int find(int a) {
        if (a == parents[a]) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }
}