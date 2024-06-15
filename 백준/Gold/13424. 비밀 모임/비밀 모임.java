import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 13424 비밀 모임
public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(graph[i], INF);
                graph[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a][b] = c;
                graph[b][a] = c;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }

            ArrayList<Integer> place = new ArrayList<>(); //모임 장소
            ArrayList<Integer> friends = new ArrayList<>();
            int k = Integer.parseInt(br.readLine()); //친구 수
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends.add(Integer.parseInt(st.nextToken()));
            }

            int min = INF;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (Integer friend : friends) {
                    int tmp = graph[i][friend] + graph[friend][i];
                    sum += tmp;
                }
                if (min > sum) {
                    min = sum;
                    place.clear();
                    place.add(i);
                } else if (min == sum) {
                    place.add(i);
                }
            }
            Collections.sort(place); //가장 작은 방 번호
//            for (Integer i : place) {
//                System.out.print(i + " ");
//            }
            sb.append(place.get(0)).append("\n");
        }
        System.out.print(sb);
    }
}