import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2529 부등호
public class Main {
    static int n;
    static char[] chr;
    static boolean[] visit = new boolean[10];
    static ArrayList<String> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chr = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            chr[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            backtracking(String.valueOf(i), i, 0); //문자열, 인덱스, 부등호 인덱스
            visit[i] = false;
        }

        System.out.println(lists.get(lists.size() - 1));
        System.out.println(lists.get(0));
    }

    static void backtracking(String result, int idx, int cnt) {
        if (cnt == n) {
            lists.add(result);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                if ((chr[cnt] == '<' && idx < i) || (chr[cnt] == '>' && idx > i)) {
                    visit[i] = true;
                    backtracking(result + i, i, cnt + 1);
                    visit[i] = false;
                }
            }
        }
    }
}