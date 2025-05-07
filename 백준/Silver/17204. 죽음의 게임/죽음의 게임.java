import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17204 죽음의 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int turn = 0; //0번부터 시작
        int count = 1;
        for (int i = 0; i < n; i++) {
            turn = num[turn];
            if (turn == k) {
                System.out.println(count);
                return;
            }
            count++;
        }
        System.out.println(-1);
    }
}