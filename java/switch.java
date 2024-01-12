import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        boolean[] b = new boolean[s.length() + 1];

        //전구가 켜져있으면 false
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'Y') {
                b[i + 1] = true;
            }
        }

        int count = 0;

        for (int i = 1; i < b.length; i++) {
            if (!b[i]) {
                continue;
            }
            count += 1;
            for (int j = i; j < b.length; j += i) {
                b[j] = !b[j];
            }
        }

        System.out.println(count);
    }
}
