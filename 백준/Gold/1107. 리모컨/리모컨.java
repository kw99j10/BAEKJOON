import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1107 리모컨
public class Main {
    static StringBuilder sb;
    static int n, min;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int start = 100; //시작 채널

        //고장난 번호가 없는 경우
        if (m == 0) {
            String t = String.valueOf(n);
            System.out.println(Math.min((Math.abs(start - n)), t.length()));
            return;
        }

        visit = new boolean[500001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            visit[Integer.parseInt(st.nextToken())] = true; //고장난 버튼
        }

        min = Math.abs(n - start); //최댓값은 + 버튼을 해당 채널 - 현재 채널 만큼 누른 값
        if (min == 0) {
            System.out.println(0);
        }else{
            sb = new StringBuilder();
            bruteforce(n);
            System.out.println(min);
        }
    }

    static void bruteforce(int channel) {

        if (sb.length() > 6) {
            return;
        }

        //채널 완탐
        for (int i = 0; i <= 9; i++) {
            if (visit[i]) {
                continue;
            }

            sb.append(i);

            int num = Integer.parseInt(sb.toString());
            int answer = Math.abs(channel - num) + sb.length();
            min = Math.min(min, answer);
            bruteforce(channel);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}