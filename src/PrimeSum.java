import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[10001];

        Arrays.fill(prime, true);

        /**
         * 에라토스테네스의 체
         **/

        for (int i = 2; i <= Math.sqrt(10000); i++) {
            for (int j = i+i; j <= 10000; j += i) {
                prime[j] = false;
            }
        }
        int t=sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();

            int tmp = n / 2;

            for (int j = tmp; j >= 2; j--) {
                if (prime[j] && prime[n - j]) {
                    System.out.println(j + " " + (n - j));
                    break;
                }
            }
        }
    }
}
/*차이가 최소인 소수가 아닌 수들의 합으로 나타낸 소수*/



