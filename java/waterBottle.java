import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 물통
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

        //각 물통의 부피
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayDeque<Bottle> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[201][201][201];
        queue.add(new Bottle(0, 0, C));

        ArrayList<Integer> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            Bottle current = queue.poll();

            //현재 물통에 있는 물의 양
            int a = current.a;
            int b = current.b;
            int c = current.c;

            if (visit[a][b][c]) {
                continue;
            }

            if (a == 0) {
                lists.add(c); //담길 수 있는 물의 양(A가 0일 때)
            }

            visit[a][b][c] = true;

            //A 물통에 물을 따름(따르는 물통 기준: 하한선, 받는 물통 기준: 상한선 판별하기)
            queue.add(new Bottle(Math.min(a + b, A), Math.max(0, b - (A - a)), c));
            queue.add(new Bottle(Math.min(a + c, A), b, Math.max(0, c - (A - a))));

            //B 물통에 물을 따름
            queue.add(new Bottle(Math.max(0, a - (B - b)), Math.min(b + a, B), c));
            queue.add(new Bottle(a, Math.min(b + c, B), Math.max(0, c - (B - b))));

            //C 물통에 물을 따름
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
