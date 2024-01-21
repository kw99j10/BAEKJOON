import java.io.IOException;
import java.util.Scanner;

//백준 스티커
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            int[][] arr = new int[2][n]; //2행 n열의 스티커

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            if (n == 1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue; //스티커가 1줄일 경우 큰 값을 출력 후 반복문 종료
            }

            int max = 0; //스티커 점수의 최댓값

            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];
            }
            max = Math.max(dp[0][n - 1], dp[1][n - 1]);
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
