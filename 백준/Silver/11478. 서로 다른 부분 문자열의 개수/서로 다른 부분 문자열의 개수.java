import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc = new Scanner(System.in);

        var h = new HashSet<String>();
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            for (int j=i+1;j<=s.length();j++) {
                h.add(s.substring(i, j));
            }
        }
        System.out.println(h.size());
    }
}






