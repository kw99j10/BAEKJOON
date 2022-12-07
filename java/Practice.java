import java.util.Scanner;

public class Practice {

    static int []sum=new int[100001];

    public static int Sum(int n){

        sum[0]=0;
        sum[1]=1;
        sum[2]=2;
        sum[3]=4;

        for (int i = 4; i <= n; i++) {
            sum[i]=sum[i-1]+sum[i-2]+sum[i-3];
        }
        return sum[n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Sum(n));
        sc.close();
    }
}