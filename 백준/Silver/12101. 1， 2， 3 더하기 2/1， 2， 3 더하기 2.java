import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 12101 1, 2, 3 더하기 2
public class Main {
    static int n, k;
    static ArrayList<String> lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        lists = new ArrayList<>();
        backtracking(0, "");
        System.out.println(k > lists.size() ? -1 : lists.get(k - 1));
    }

    static void backtracking(int sum, String tmp) {
        if (sum >= n) {
            if (sum == n) {
                lists.add(tmp);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum == 0) {
                backtracking(sum + i, String.format("%d", i));
            }else{
                backtracking(sum + i, String.format("%s+%d", tmp, i));
            }
        }
    }
}