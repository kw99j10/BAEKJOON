import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//숫자고르기
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n + 1];
        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    static void dfs(int start, int end) {

        if (arr[start] == end) {
            result.add(end);
            return;
        }

        if (!visit[arr[start]]) {
            visit[arr[start]] = true;
            dfs(arr[start], end);
            visit[arr[start]] = false;
        }
    }
}