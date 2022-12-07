import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if(c=='O') {
                sum += 1;
                count += sum - 1;
                count += i + 1;
            }

            else
                sum = 0;
        }
        System.out.println(count);
    }
}






