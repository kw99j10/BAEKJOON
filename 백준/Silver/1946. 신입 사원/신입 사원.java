import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1946 신입 사원
public class Main {
    static class Score implements Comparable<Score> {
        int document, face;

        public Score(int document, int face) {
            this.document = document;
            this.face = face;
        }

        @Override
        public int compareTo(Score o) {
            return this.document - o.document;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;

            PriorityQueue<Score> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                queue.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            int count = 1;
            int max = queue.poll().face; // 서류 성적 순으로 정렬하였으므로 면접 성적만 비교
            while (!queue.isEmpty()) {
                int next = queue.poll().face;
                if (max > next) {
                    count++;
                    max = next; // 상한선
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}