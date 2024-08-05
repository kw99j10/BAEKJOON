import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] lists;
    static int[] time;
    static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            lists = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }

            time = new int[n + 1];
            degree = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                lists[a].add(b);
                degree[b] += 1;
            }

            int w = Integer.parseInt(br.readLine()); //목표 건물
            sort(n);
            sb.append(time[w]).append("\n");
        }
        System.out.print(sb);
    }

    private static void sort(int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(new int[]{i, time[i]});
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];

            for (Integer next : lists[num]) {

                degree[next] -= 1;

                if (degree[next] == 0) {
                    time[next] += time[num];
                    queue.add(new int[]{next, time[next]});
                }
            }
        }
    }
}
