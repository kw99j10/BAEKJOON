import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 25418 정수 a를 k로 만들기
public class Main {
    static int a, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[1000001];
        queue.add(a);
        visit[a] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == k) {
                    System.out.println(count);
                    return;
                }
                if (1000000 >= current + 1 && !visit[current + 1]) {
                    visit[current + 1] = true;
                    queue.add(current + 1);
                }

                if (1000000 >= current * 2 && !visit[current * 2]) {
                    visit[current * 2] = true;
                    queue.add(current * 2);
                }
            }
            count++;
        }
    }
}