package hello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        //두 문자열의 lcs를 구하기 위한 dp 배열
        int[][] dp = new int[c1.length + 1][c2.length + 1];

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] != c2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //같지 않다면 이전까지의 최댓값을 덮어 씌움
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1; //공통 문자라면 길이를 증가
                }
            }
        }
        System.out.println(dp[c1.length][c2.length]);
    }
}
