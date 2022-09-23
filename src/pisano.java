import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc=new Scanner(System.in);

        long n=sc.nextLong();

        //피보나치 수를 나눈 나머지는 항상 주기를 가진다. ==피사노 주기
        //1000000을 나눈 나머지를 한다는 가정하에 1500000번을 주기로 똑같은 값이 주어진다
        int k=1500000;
        n = n % k;

        long[] arr = new long[k + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= k; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
        }

        System.out.println(arr[(int) n]);
    }
}






