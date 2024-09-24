import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 14405 피카츄
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.replace("pi", " ");
        s = s.replace("ka", " ");
        s = s.replace("chu", " ");
        s = s.replace(" ", "");
        if (s.isEmpty()) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}