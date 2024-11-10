import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2302 극장 좌석
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] seat = new int[41]; //극장 좌석
        seat[0] = 1;
        seat[1] = 1;
        for (int i = 2; i <= 40; i++) {
            seat[i] = seat[i - 1] + seat[i - 2];
        }

        int start = 0;
        int answer = 1;
        int m = Integer.parseInt(br.readLine()); //고정석의 개수
        for (int i = 0; i < m; i++) {
            int fix = Integer.parseInt(br.readLine());
            answer *= seat[fix - start - 1]; // 이전까지의 가짓수(구간 계산)
            start = fix;
        }
        answer *= seat[n - start]; // 마지막 구간
        System.out.println(answer);
    }
}