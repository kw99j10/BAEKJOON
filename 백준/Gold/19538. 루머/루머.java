import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 19538 루머
public class Main {
    static int n, m;
    static ArrayList<Integer>[] lists;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static int[] time;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    break;
                }
                lists[i].add(num);
            }
        }

        count = new int[n + 1]; // 루머를 믿는 사람 수
        time = new int[n + 1]; // 루머를 믿기 시작한 시간
        Arrays.fill(time, -1);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            queue.add(num);
            time[num] = 0; // 최초 유포자
        }
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(time[i]).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs() {

        // 매분 루머를 믿는 사람이 모든 주변인에게 퍼뜨림
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : lists[current]) {
                if (time[next] != -1) {
                    continue;
                }
                count[next]++;

                // 주변인 절반 이상이 루머를 믿으면 자신도 믿음
                if (count[next] * 2 >= lists[next].size()) {
                    time[next] = time[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}