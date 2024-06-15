import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 21940 가운데에서 만나기
public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(city[i], INF);
            city[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            city[a][b] = Math.min(city[a][b], t);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }

        ArrayList<Integer> lists = new ArrayList<>(); //왕복시간 최소 도시
        ArrayList<Integer> friends = new ArrayList<>(); //친구들
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            friends.add(Integer.parseInt(st.nextToken()));
        }

        int max = INF;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (Integer friend : friends) {
                sum = Math.max(sum, city[i][friend] + city[friend][i]);
            }

            if (max > sum) {
                max = sum;
                lists.clear(); //최대가 최소가 되는 도시 갱신
                lists.add(i);
            } else if (max == sum) {
                lists.add(i);
            }
        }

        Collections.sort(lists); //도시 번호 오름차순
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list).append(" ");
        }
        System.out.print(sb);
    }
}