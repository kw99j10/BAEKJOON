import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14217 그래프 탐색
public class Main {
    static int n, m;
    static int[][] road;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        road = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a][b] = road[b][a] = 1;
        }

        int q = Integer.parseInt(br.readLine()); // 도로 정비 계획
        sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (a == 1) {
                road[u][v] = road[v][u] = 1; // 도로를 지음
            } else {
                road[u][v] = road[v][u] = -1; // 도로를 없앰
            }
            
            bfs();
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1); // 수도에서 시작
        distance[1] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (road[current][i] == 1 && distance[i] == -1) {
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(distance[i]).append(" ");
        }
    }
}