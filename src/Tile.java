import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 1;
        int b = 2;
        int k = 3;

        if (n==1)
            System.out.println(a);

        else if(n==2)
            System.out.println(b);

        else{
            for (int i = 3; i <= n; i++) {

                k = a + b;
                k = k % 10007;
                /**
                 마지막에만 %10007 연산을 해줄 시 중간에 저장되는 값들이
                 int값을 넘어서므로 오버플로우가 발생한다.*
                 */
                a = b;
                b = k;
            }
            System.out.println(k);
        }
    }
}

