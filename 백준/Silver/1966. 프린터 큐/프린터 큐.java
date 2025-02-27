import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1966 프린터 큐
public class Main {
    static class Number {
        int num, idx;

        public Number(int num, int idx) {
            this.num = num; // 중요도
            this.idx = idx; // 인덱스
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        LinkedList<Number> queue = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                queue.add(new Number(tmp, i));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Number current = queue.poll();
                boolean isPossible = true;
                for (int i = 0; i < queue.size(); i++) {
                    if (queue.get(i).num > current.num) {
                        queue.addLast(current);
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    continue;
                }

                count++;
                if (current.idx == m) {
                    sb.append(count).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}