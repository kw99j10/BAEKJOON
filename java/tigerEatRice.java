import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * baekjoon 2502 떡먹는 호랑이
 *
 */
public class tigerEatRice {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int d=sc.nextInt();
        int k=sc.nextInt();

        int []dp=new int[31];
        dp[1]=1;
        dp[2]=1;

        for (int i=3;i<=30;i++)
            dp[i]=dp[i-2]+dp[i-1];

        //a와 b에 대한 피보나치식  a->b->a+b->a+2b->2a+3b->3a+5b....
        // 따라서 a*dp[i-2]+b*dp[i-1]=k 라는 점화식이 만들어짐 ==> b=k-(a*dp[i-2])%dp[i-1]
        //a를 1로두고 계산 시작
        int a=1;
        int b;
        while (true){

            if ((k-dp[d-2]*a)%dp[d-1]==0){
                b=(k-dp[d-2]*a)/dp[d-1];
                break;
            }
            a+=1;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
