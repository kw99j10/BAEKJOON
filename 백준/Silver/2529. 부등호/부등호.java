import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//2529 부등호
public class Main {
    static String[] num;
    static String[] str;
    static boolean[] visit;
    static ArrayList<String> list;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        str = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            str[i] = st.nextToken();
        }

        num = new String[10];
        visit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            num[i] = String.valueOf(i);
        }

        list = new ArrayList<>();
        backtracking("", 0); //부등호 관계 조합

        // 최대 정수 && 최소 정수
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void backtracking(String result, int idx) {
        if (idx == n + 1) {
            list.add(result);
            return;
        }

        // 0~9 경우의 수 완탐
        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                if (idx == 0 || isPossible(Integer.parseInt(String.valueOf(result.charAt(idx - 1))), Integer.parseInt(num[i]), str[idx - 1])) {
                    visit[i] = true;
                    backtracking(result + i, idx + 1);
                    visit[i] = false;
                }
            }
        }
    }

    static boolean isPossible(int a, int b, String c) {
        if (c.equals(">")) {
            return a >= b;
        }
        else{
            return a <= b;
        }
    }
}