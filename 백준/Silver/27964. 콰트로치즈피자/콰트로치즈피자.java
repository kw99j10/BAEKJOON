import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 27964 콰트로치즈피자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (st[i].endsWith("Cheese")) {
                set.add(st[i]);
            }
        }
        System.out.println(set.size() >= 4 ? "yummy" : "sad");
    }
}