import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가르침
public class Main {
    static int n, k, max;
    static boolean[] alpha;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        //남극언어 단어 규칙 (5개 기본)
        alpha = new boolean[26];
        alpha['a' - 97] = true;
        alpha['n' - 97] = true;
        alpha['t' - 97] = true;
        alpha['i' - 97] = true;
        alpha['c' - 97] = true;

        if (k < 5) {
            System.out.println(0); //5개보다 적은 단어는 읽을 수 없음
        } else if (k == 26) {
            System.out.println(n); //다 읽을 수 있다면 모든 단어를 읽을 수 있음
        } else {
            backtracking(0, 5);
            System.out.println(max);
        }
    }

    static void backtracking(int idx,int count) {

        if (count == k) {
            max = Math.max(max, countWords());
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (!alpha[i]) {
                alpha[i] = true;
                backtracking(i + 1, count + 1);
                alpha[i] = false;
            }
        }
    }

    private static int countWords() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean isPossible = true;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!alpha[c - 97]) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                cnt++;
            }
        }
        return cnt;
    }
}
