import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2810 컵홀더
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        s = s.replace("LL", "L");
        if (!s.contains("L")) {
            System.out.println(n);
        } else {
            System.out.println(s.length() + 1);
        }
    }
}