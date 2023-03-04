import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 12865 평범한 배낭
 *
 */
public class Bag {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt(); //준서가 버틸 수 있는 무게 K(1~100000)

        //각 물건의 무게와 가치를 담을 배열
        int []w=new int[n+1];
        int []v=new int[n+1];

        for (int i=1;i<=n;i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }

        //최대 무게 k까지의 가치를 담는 배열
        // [n+1]:들어오는 물건, [k+1]:최대 무게
        int [][]dp=new int[n+1][k+1];

        for (int i=1;i<=n;i++){
            for (int j=1;j<=k;j++){

                //이전 물건의 가치를 저장
                dp[i][j]=dp[i-1][j];

                //무게가 남으면 최대값 갱신
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j -w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
