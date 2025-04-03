import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Calculate implements Comparable<Calculate>{
        long num;
        String word;

        public Calculate(long num, String word) {
            this.num = num;
            this.word = word;
        }

        @Override
        public int compareTo(Calculate o) {
            if (this.word.length() == o.word.length()) {
                return this.word.compareTo(o.word);
            }
            return this.word.length() - o.word.length();
        }
    }
    static long s, t;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        if (s == t) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs() ? answer : -1);
    }
    static boolean bfs() {
        PriorityQueue<Calculate> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.add(new Calculate(s, ""));
        set.add(s);
        while (!queue.isEmpty()) {
            Calculate current = queue.poll();
            if (current.num == t) {
                answer = current.word;
                return true;
            }

            long plus = current.num + current.num;
            long minus = current.num - current.num;
            long multiply = current.num * current.num;
            long divide = 0;
            if (current.num != 0) {
                divide = current.num / current.num;
            }

            if (!set.contains(multiply)) {
                set.add(multiply);
                queue.add(new Calculate(multiply, current.word + "*"));
            }

            if (!set.contains(plus)) {
                set.add(plus);
                queue.add(new Calculate(plus, current.word + "+"));
            }

            if (!set.contains(minus)) {
                set.add(minus);
                queue.add(new Calculate(minus, current.word + "-"));
            }

            if (!set.contains(divide)) {
                set.add(divide);
                queue.add(new Calculate(divide, current.word + "/"));
            }
        }
        return false;
    }
}