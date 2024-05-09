import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 0 만들기
public class Main {
    static int n;
    static char[] opt = {' ', '+', '-'}; //아스키 콛 ㅡ순서
    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            result = new ArrayList<>();
            subset("1", 1);
            for (String s : result) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void subset(String s, int cnt) {
        if (cnt == n) {
            String tmp = s.replaceAll(" ", ""); //공백 문자 치환

            //'+','-'는 구분자이지만 토큰에 포함
            StringTokenizer st = new StringTokenizer(tmp, "+|-", true);
            int sum = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("+")) {
                    sum += Integer.parseInt(st.nextToken());
                } else {
                    sum -= Integer.parseInt(st.nextToken());
                }
            }
            if (sum == 0) {
                result.add(s);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            subset(s + opt[i] + (cnt + 1), cnt + 1); //연산자 순서 부분집합
        }
    }
}