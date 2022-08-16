package hello.core;
import java.util.Scanner;

public class 금민수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = String.valueOf(n);

        while (true) {

            boolean oxt = true;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) != '4' && s.charAt(i) != '7') {
                    oxt = false;
                    break;
                }
            }
            if (oxt)
                break;
            else
                s = String.valueOf(Integer.parseInt(s) - 1);
        }
        System.out.println(s);
    }
}
