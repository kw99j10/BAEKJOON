import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 11003 최솟값 찾기
public class Main {
    static class Num {
        int num, idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Num> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!queue.isEmpty() && i - queue.getFirst().idx >= l) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.getLast().num > num) {
                queue.removeLast(); // 현재 값보다 크다면 최솟값이 될 수 없음
            }

            queue.addLast(new Num(num, i));
            sb.append(queue.getFirst().num).append(" ");
        }
        System.out.print(sb);
    }
}