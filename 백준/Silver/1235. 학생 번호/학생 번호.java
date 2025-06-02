import java.io.*;
import java.util.*;

// 1235 학생 번호
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] name = new String[n];

        for (int i = 0; i < n; i++) {
            name[i] = br.readLine();
        }

        int min = 0;
        for (int i = 1; i <= name[0].length(); i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = n - 1; j >= 0; j--) {
                set.add(name[j].substring(name[0].length() - i));
            }
            if (set.size() == n) {
                min = i;
                break;
            }
        }
        System.out.println(min);
    }
}