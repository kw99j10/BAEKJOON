import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3153 합이 0 - 풀이 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        //범위가 -10000 ~ 10000 => 합의 범위는 -20000 ~ 20000
        int[] student = new int[40001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += student[20000 - num[i]];
            for (int j = 0; j < i; j++) {
                student[20000 + num[i] + num[j]]++;
            }
        }
        System.out.println(cnt);
    }
}