import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] degree = new int[32001]; //진입 차수 비교
    static ArrayList<Integer>[] lists;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); //a > b
            lists[a].add(b);
            degree[b] += 1;
        }

        result = new ArrayList<>(); //줄을 세운 결과
        topology(); //위상 정렬

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
    static void topology() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i); //위상이 0인 노드를 큐에 넣음
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll(); //진입 차수가 0이 된 노드
            result.add(current);

            for (Integer next : lists[current]) {
                degree[next] -= 1;

                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
