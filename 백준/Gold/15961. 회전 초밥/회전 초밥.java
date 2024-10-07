import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15961 회전 초밥
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 가짓 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (sushi[arr[i]] == 0) {
                cnt++;
            }
            sushi[arr[i]]++;
        }
        int max = cnt;

        for (int i = 0; i < n; i++) {
            if (cnt >= max) {
                if (sushi[c] == 0) {
                    max = cnt + 1;
                }else{
                    max = cnt;
                }
            }

            sushi[arr[i]]--;
            if (sushi[arr[i]] == 0) {
                cnt--;
            }

            int next = (i + k) % n;
            if (sushi[arr[next]] == 0) {
                cnt++;
            }
            sushi[arr[next]]++;
        }
        System.out.println(max);
    }
}