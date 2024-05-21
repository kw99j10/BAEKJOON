import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 24446
public class Main {

    static int n;
    static ArrayList<Integer>[] lists;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }
        arr[r] = 0;
        bfs(r);
        for (int i = 1; i <= n; i++) {
            if (i != r && arr[i] == 0) {
                System.out.println(-1);
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer next : lists[current]) {
                if (!visit[next]) {
                    visit[next] = true;
                    arr[next] = arr[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}