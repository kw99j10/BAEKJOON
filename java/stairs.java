import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 2579 계단 오르기
 *
 */
public class stairs {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //계단의 개수(<=300)
        int[] s = new int[301];

        for (int i = 1; i <= t; i++) {
            s[i] = sc.nextInt();
        }
        //누적합을 저장할 배열
        /**
         * 경우의 수 1: n에 도달하기 전에 n-2를 밟았을 때
         * 경우의 수 2: n에 도달하기 전에 n-1를 밟았을 때(n-3 도 무조건 밟아야 함)
         */
        int[] dp = new int[301];
        dp[1] = s[1];
        dp[2] = s[1] + s[2];

        for (int i = 3; i <= t; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + s[i - 1]) + s[i];
        }
        System.out.println(dp[t]);
    }
}
