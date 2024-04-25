import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BFS 스페셜 저지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[n + 1];

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        int[] sequence = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        if (sequence[1] != 1) {
            System.out.println(0); //무조건 1부터 시작해야 함 (조건 1)
            return;
        }

        int child = 2;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visit[1] = true;

        //부모 노드의 방문 순서 => 자식 노드의 방문 순서 일치해야 함(2-2 조건)
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            int count = 0; //자식의 수
            for (Integer next : lists[current]) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                }
            }

            for (int i = child; i < child + count; i++) {
                if (!visit[sequence[i]]) {
                    System.out.println(0);
                    return; //자식을 방문하지 않은 경우 (2-2 조건 위배)
                }
                queue.add(sequence[i]);
            }
            child += count;
        }
        System.out.println(1);
    }
}
