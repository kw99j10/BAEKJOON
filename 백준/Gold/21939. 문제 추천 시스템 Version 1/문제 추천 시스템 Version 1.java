import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 21939 문제 추천 시스템 Version 1
public class Main {
    static class Problem implements Comparable<Problem> {
        int num, level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (o.level == this.level) {
                return this.num - o.num;
            }
            return this.level - o.level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeSet<Problem> tree = new TreeSet<>();//문제, 난이도 관리  큐 2개 -> ts 1개
        HashMap<Integer, Integer> map = new HashMap<>(); //문제번호, 난이도

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            tree.add( new Problem(num, level));
            map.put(num, level);
        }

        //명령문 입력
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            //큐에 해당 문제번호 추가
            if (order.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                tree.add(new Problem(num, level));
                map.put(num, level);
            }

            //문제 번호 출력
            else if (order.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    sb.append(tree.last().num); //가장 어려운 문제 번호
                } else {
                    sb.append(tree.first().num); //가장 쉬운 문제 번호
                }
                sb.append("\n");
            }

            // 문제 번호 제거
            else {
                int num = Integer.parseInt(st.nextToken());
                tree.remove(new Problem(num, map.get(num)));
            }
        }
        System.out.print(sb);
    }
}