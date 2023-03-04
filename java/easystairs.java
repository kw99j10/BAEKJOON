import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 10844 쉬운 계단 수 -dp 프로그래밍
 *
 */
public class easystairs {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //n자릿수에 대한 각각의 자릿 값
        long[][] dp = new long[n + 1][10];

        //n이 1자릿수일 경우 경우의 수
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < 10; j++) {

                //0이 가운데일 경우 1만 올 수 있다.
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                }

                //9가 가운데일 경우 8만 올 수 있다.
                else if (j==9){
                    dp[i][9]=dp[i-1][8]%1000000000;
                }
                else {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }
        long sum=0;

        for (int i=0;i<10;i++)
            sum+=dp[n][i];
        System.out.println(sum%1000000000);
    }
}
