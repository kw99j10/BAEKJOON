import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String tmp = name.substring(0, 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        boolean isPossible = false;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 5) {
                sb.append(entry.getKey());
                isPossible = true;
            }
        }

        System.out.print(!isPossible ? "PREDAJA" : sb.toString());
    }
}