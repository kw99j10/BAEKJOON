import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1495 기타리스트
public class Main {
    static int n, s, m, total = -1;
    static int[] volume;

    static class Guitar implements Comparable<Guitar> {
        int count, volume;

        public Guitar(int count, int volume) {
            this.count = count;
            this.volume = volume;
        }

        @Override
        public int compareTo(Guitar o) {
            return o.volume - this.volume;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()); // 시작 볼륨
        m = Integer.parseInt(st.nextToken()); // 제한 볼륨

        volume = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        bfs();
    }

    static void bfs() {
        PriorityQueue<Guitar> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[n + 1][m + 1]; // 곡, 볼륨

        queue.add(new Guitar(0, s));
        visit[0][s] = true;

        while (!queue.isEmpty()) {
            Guitar current = queue.poll();
            int gok = current.count;
            int sound = current.volume;

            if (gok == n) {
                total = Math.max(total, sound);
                continue; // 최댓값 경우의 수 갱신
            }

            int max = sound + volume[gok];
            int min = sound - volume[gok];

            if (max <= m && !visit[gok][max]) {
                visit[gok][max] = true;
                queue.add(new Guitar(gok + 1, max));
            }

            if (min >= 0 && !visit[gok][min]) {
                visit[gok][min] = true;
                queue.add(new Guitar(gok + 1, min));
            }
        }
        System.out.println(total);
    }
}