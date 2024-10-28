import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 8979 올림픽
public class Main {
    static class Medal implements Comparable<Medal> {
        int num, gold, silver, bronze;

        public Medal(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Medal o) {
            if (o.gold == this.gold) {
                if (o.silver == this.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Medal> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            queue.add(new Medal(num, gold, silver, bronze));
        }

        int cnt = 0;
        while (true) {
            if (!queue.isEmpty() && cnt == k - 1) {
                System.out.println(queue.peek().num);
                break;
            }
            queue.poll();
            cnt++;
        }
    }
}