import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InfiniteString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();


        StringBuilder s1 = new StringBuilder(s); //s의 무한 문자열
        StringBuilder t1 = new StringBuilder(t); //t의 무한 문자열

        /*무한 문자열 비교*/
        //길이가 같다면 문자열 그 자체만 두고 비교
        if (s.length()==t.length()) {
            if (s.equals(t))
                System.out.println(1);

            else
                System.out.println(0);
        }

        //길이가 다르다면 최소공배수 비교
        else {
             int len = lcm(s.length(), t.length());

             while (s1.length() != len) {
                s1.append(s);
             }

            while (t1.length() != len) {
                t1.append(t);
            }

            if (s1.toString().equals(t1.toString()))
                System.out.println(1);

            else
                System.out.println(0);
        }
    }

    //최대 공약수 로직
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r=a%b;

            a=b;
            b=r;
        }
        return a;
    }

    //최소 공배수 로직
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
