import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//List of Unique Numbers
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        long answer = 0; //값이 int형 범위 밖에 있음 주의
        boolean[] check = new boolean[100001];
        while (true) {
            if (end == n) {
                answer += end - start; //중복되지 않은 연속 수만큼 값을 더함
                start++;
                if (start == n) {
                    break; //두 포인터 모두 n에 도착 시 반복문 종료 
                }
            } else if (!check[arr[end]]) {
                check[arr[end++]] = true;
            } else {
                answer += end - start;
                check[arr[start++]] = false;
            }
        }
        System.out.println(answer);
    }
}
