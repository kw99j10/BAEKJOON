import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 1544 사이클 단어
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (set.isEmpty()) {
                set.add(s);
            } else {
                boolean isSame = false;
                for (int j = 0; j < s.length(); j++) {
                    String tmp = s.substring(j) + s.substring(0, j);
                    if (set.contains(tmp)) {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame) {
                    set.add(s);
                }
            }
        }
        System.out.println(set.size());
    }
}