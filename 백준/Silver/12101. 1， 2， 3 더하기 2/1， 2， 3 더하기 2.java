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
        backtracking(0, new StringBuilder());
        System.out.println(k > lists.size() ? -1 : lists.get(k - 1));
    }

    static void backtracking(int sum, StringBuilder tmp) {
        if (sum >= n) {
            if (sum == n) {
                lists.add(tmp.substring(0, tmp.length() - 1));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, new StringBuilder().append(tmp).append(i).append("+"));
        }
    }
}