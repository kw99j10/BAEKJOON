import java.io.BufferedReader;
import java.io.InputStreamReader;

//A와 B - 2
public class Main {
    static String s, t;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        dfs(t);
        System.out.println(answer);
    }

    static void dfs(String t) {
        if (t.equals(s)) {
            answer = 1; //T -> S (T 제거 방식)
            return;
        }

        //문자열 뒤 A 추가 -> 마지막 문자열이 A이면 삭제
        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length() - 1));
        }

        //문자열 뒤 B 추가 후 뒤집기 -> 시작 문자열이 B이면 삭제 
        if (t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
