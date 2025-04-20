import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 10546 배부른 마라토너
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) - 1);
            if (map.get(s) == 0) {
                map.remove(s);
            }
        }

        String answer = "";
        for (String s : map.keySet()) {
            answer = s;
        }
        System.out.println(answer);
    }
}