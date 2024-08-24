import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1043 거짓말 
public class Main {
    static int n, answer;
    static int[] parents;
    static ArrayList<Integer>[] party; // 파티에 참여한 사람

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = m; //이야기를 할 수 있는 최대 파티 개수

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());

        if (know == 0) {
            System.out.println(answer); // 없다면 파티 수와 같음
            return;
        }

        int[] known = new int[know + 1]; // 진실을 아는 사람
        for (int i = 1; i <= know; i++) {
            known[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            party[i].add(start);
            for (int j = 1; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                party[i].add(next);
                union(start, next); // 같은 파티 -> 같은 집합
            }
        }

        for (int i = 1; i <= m; i++) {
            int start = party[i].get(0);
            for (int j = 1; j <= know; j++) {
                if (find(start) == find(known[j])) {
                    answer--;
                    break;
                }
            }
        }


        System.out.println(answer);
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