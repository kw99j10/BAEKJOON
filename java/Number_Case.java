import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/* baekjoon-S3 9375 패션왕 신해빈:경우의 수 문제*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            var h = new HashMap<String, Integer>();
            
            for (int j = 0; j < n; j++) {

                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String t2 = st.nextToken();

                if (!h.containsKey(t2))
                    h.put(t2, 1);

                else
                    h.put(t2, h.get(t2) + 1);//같은 key가 넘어오면 누적
            }
            int count = 1; //경우의 수(최소 1개 이상)

            for (int val : h.values()) {
                count *= (val + 1);
            }

            sb.append(count - 1).append("\n"); //아무 것도 입지 않을 경우인 1을 빼줌
        }
        System.out.print(sb);
    }
}
