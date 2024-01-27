import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//알고리즘 수업 - 깊이 우선 탐색 1
public class Main {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static int[] visit; //방문한 가중치를 저장할 배열
    static int count; //가중치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        visit = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]); //오름차순 정렬
        }
        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visit[i]);
        }
    }

    private static void dfs(int current) {
        visit[current] = ++count; //현재 노드

        for (int next : arr[current]) {
            if (visit[next] == 0) {
                dfs(next); //인접 노드 dfs
            }
        }
    }
}
