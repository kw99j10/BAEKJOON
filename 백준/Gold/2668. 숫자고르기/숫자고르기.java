import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

//숫자고르기
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> tmp;
    static TreeSet<Integer> result;

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
        tmp = new ArrayList<>();
        result = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                tmp = new ArrayList<>();
                visit[i] = true;
                tmp.add(i);
                dfs(i, i);
            }
        }
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    static void dfs(int start, int end) {
        if (arr[start] == end) {
            result.addAll(tmp);
            return;
        }

        if (!visit[arr[start]]) {
            visit[arr[start]] = true;
            tmp.add(arr[start]);
            dfs(arr[start], end);
            visit[arr[start]] = false;
        }
    }
}