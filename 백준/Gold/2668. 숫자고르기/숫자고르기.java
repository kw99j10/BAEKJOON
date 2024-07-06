import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//2668 숫자고르기
public class Main {
    static int n;
    static int[] num;
    static boolean[] visit;
    static ArrayList<Integer> lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        visit = new boolean[n + 1];
        lists = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer next : lists) {
            sb.append(next).append("\n");
        }
        System.out.println(lists.size());
        System.out.print(sb);
    }

    static void dfs(int start, int end) {

        //정수들이 이루는 집합 = 뽑힌 정수들의 바로 밑의 정수들의 집합
        if (num[start] == end) {
            lists.add(end);
            return;
        }

        if (!visit[num[start]]) {
            visit[num[start]] = true;
            dfs(num[start], end);
            visit[num[start]] = false;
        }
    }
}