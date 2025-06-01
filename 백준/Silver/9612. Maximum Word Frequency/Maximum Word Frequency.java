import java.io.*;
import java.util.*;

// 9612
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = Collections.max(map.values());
        String frequency = "";
        for (String s : map.keySet()) {
            if (map.get(s) == max && frequency.compareTo(s) < 0) {
                frequency = s;
            }
        }
        System.out.println(frequency + " " + max);
    }
}