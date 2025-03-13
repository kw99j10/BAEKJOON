import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2655 가장높은탑쌓기
public class Main {
    static class Stone implements Comparable<Stone> {
        int num, area, height, weight;

        public Stone(int num, int area, int height, int weight) {
            this.num = num;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Stone o) {
            return o.area - this.area;
        }
    }

    static PriorityQueue<Stone> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Stone(i, a, h, w));
        }

        ArrayList<Stone> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            lists.add(queue.poll());
        }

        int[] dp = new int[n];
        int max = dp[0] = lists.get(0).height;

        // 밑면이 넓은 순, 무게가 무거운 순으로 쌓아야 함
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (lists.get(j).weight > lists.get(i).weight) {
                    dp[i] = Math.max(dp[i], dp[j] + lists.get(i).height);
                    cnt++;
                }
            }

            if (cnt == 0) {
                dp[i] = lists.get(i).height;
            }
            max = Math.max(max, dp[i]);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (dp[n - 1] == max) {
                max -= lists.get(n - 1).height;
                sb.append(lists.get(n - 1).num).append("\n");
                cnt++;
            }
            n--;
        }
        System.out.println(cnt);
        System.out.print(sb);
    }
}