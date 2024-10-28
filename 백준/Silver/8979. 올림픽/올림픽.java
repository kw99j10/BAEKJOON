import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 8979 올림픽
public class Main {
    static class Medal implements Comparable<Medal> {
        int num, gold, silver, bronze;

        public Medal(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Medal o) {
            if (o.gold != this.gold) {
                return o.gold - this.gold;
            }
            if (o.silver != this.silver) {
                return o.silver - this.silver;
            }
            return o.bronze - this.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고싶은 국가

        ArrayList<Medal> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            lists.add(new Medal(num, gold, silver, bronze));
        }
        Collections.sort(lists); // 조건 순 정렬

        int rank = 1;
        int diff = 0;
        int[] ranks = new int[n + 1];
        ranks[lists.get(0).num] = rank;
        for (int i = 1; i < n; i++) {
            Medal before = lists.get(i - 1);
            Medal current = lists.get(i);

            //공동
            if (before.gold == current.gold && before.silver == current.silver && before.bronze == current.bronze) {
                ranks[current.num] = rank;
                diff++;
            } else {
                rank += 1;
                ranks[current.num] = rank + diff;
                diff = 0;
            }
        }
        
        System.out.println(ranks[k]);
    }
}