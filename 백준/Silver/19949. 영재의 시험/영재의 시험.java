import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19949 영재의 시험
public class Main {
    static int[] answer;
    static int[] result;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        result = new int[10];
        perm(0);
        System.out.println(ans);
    }

    static void perm(int idx) {
        if (idx == 10) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == result[i]) {
                    count++;
                }
            }
            if (count >= 5) {
                ans++; // 점수가 5점 이상인 경우
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (idx >= 2) {
                if (result[idx - 2] == result[idx - 1] && result[idx - 1] == i) {
                    continue; // 3개 연속된 문제 답 x
                }
            }
            result[idx] = i;
            perm(idx + 1);
        }
    }
}