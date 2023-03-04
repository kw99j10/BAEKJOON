import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 17626 Four Squares
 *
 */
public class SqrtSum {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int []a=new int[50001];
        a[1]=1;

        //필요로하는 제곱수를 최소화 하기위해 n까지 범위에 임의의 최대값 지정
        for (int i=2;i<=n;i++)
            a[i]=Integer.MAX_VALUE;

        for (int i=2;i<=50000;i++){
            for (int j = 1; j*j <= i; j++) {
                a[i] = Math.min(a[i], a[i-j*j]+1);
            }
        }
        System.out.println(a[n]);
    }
}
