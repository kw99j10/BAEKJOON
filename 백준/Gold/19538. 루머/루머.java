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
    static ArrayList<Integer> first = new ArrayList<>();
    static int[] time;

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

        time = new int[n + 1]; // 루머를 믿기 시작한 시간
        Arrays.fill(time, -1);


        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            first.add(num);
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
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{first.get(i), 0});
        }

        // 매분 루머를 믿는 사람이 모든 주변인에게 퍼뜨림
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0]; // 루머를 믿는 사람
            int rumor = current[1]; // 믿는 순간의 시간

            // 처음 믿은 시간
            time[node] = (time[node] == -1) ? rumor : Math.min(time[node], rumor);

            // 현재 믿는 사람의 주변인 시간을 체크
            for (int i = 0; i < lists[node].size(); i++) {
                int next = lists[node].get(i);
                int size = lists[next].size();

                if (time[next] >= 0) {
                    continue; // 이미 루머를 믿는 사람이면 넘어감
                }

                int count = 0;
                for (int j = 0; j < size; j++) {
                    int nx = lists[next].get(j);
                    if (time[nx] >= 0) {
                        count++;
                    }
                }

                // 주변인 절반 이상이 루머를 믿으면 자신도 믿음
                if (count * 2 >= size) {
                    queue.add(new int[]{next, rumor + 1});
                }
            }
        }
    }
}