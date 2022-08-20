import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        for (int i=1;i<n;i++)
            System.out.print(" ");
        System.out.println("*"); 
        
        //첫번째 줄 출력 형식

        for (int i = 2; i < n; i++) {
            for (int j = n-i; j > 0; j--)
                System.out.print(" ");
            System.out.print("*");

            for (int j = 1; j <= (i-1)*2-1; j++)
                System.out.print(" ");
            System.out.println("*");
        }
        //2~n-1번째 줄 출력 방식, 공백 표현

        if (n != 1) {
            for (int i=0;i<2*n-1;i++)
                System.out.print("*");
            System.out.println();
        }
        //마지막 줄 출력 방식
    }
}





