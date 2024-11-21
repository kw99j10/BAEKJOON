import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1205 등수 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 현재 리스트에 있는 요소 개수
        int newScore = Integer.parseInt(st.nextToken()); // 태수의 점수
        int p = Integer.parseInt(st.nextToken()); // 리스트에 들어갈 수 있는 요소 개수

        if (n == 0) {
            System.out.println(1);
            return;
        }

        ArrayList<Integer> lists = new ArrayList<>(); //랭킹 리스트
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lists.add(Integer.parseInt(st.nextToken()));
        }

        if (n == p && lists.get(lists.size() - 1) >= newScore) {
            System.out.println(-1);
            return; // 리스트에 못 올라가는 경우
        }
        int rank = 1;
        for (Integer list : lists) {
            if (list > newScore) {
                rank++;
            } else {
                break;
            }
        }
        System.out.println(rank);
    }
}