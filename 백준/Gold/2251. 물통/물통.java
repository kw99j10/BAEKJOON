import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Bottle {
        int a, b, c;
        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayDeque<Bottle> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[201][201][201];
        queue.add(new Bottle(0, 0, C));

        ArrayList<Integer> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            Bottle current = queue.poll();
            int a = current.a;
            int b = current.b;
            int c = current.c;

            if (visit[a][b][c]) {
                continue;
            }

            if (a == 0) {
                lists.add(c); 
            }
            visit[a][b][c] = true;

            queue.add(new Bottle(Math.min(a + b, A), Math.max(0, b - (A - a)), c));
            queue.add(new Bottle(Math.min(a + c, A), b, Math.max(0, c - (A - a))));

            queue.add(new Bottle(Math.max(0, a - (B - b)), Math.min(b + a, B), c));
            queue.add(new Bottle(a, Math.min(b + c, B), Math.max(0, c - (B - b))));

            queue.add(new Bottle(Math.max(0, a - (C - c)), b, Math.min(c + a, C)));
            queue.add(new Bottle(a, Math.max(0, b - (C - c)), Math.min(c + b, C)));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(lists);
        for (Integer i : lists) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}