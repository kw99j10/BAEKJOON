import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

            int sum = 0;
            int num = 0;
            int check = 1;
            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if (c == '+') {
                    sum += check * num;
                    num = 0;
                    check = 1;
                } else if (c == '-') {
                    sum += check * num;
                    num = 0;
                    check = -1;
                } else {
                    num = num * 10 + (c - '0');
                }
            }
            sum += check * num;
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