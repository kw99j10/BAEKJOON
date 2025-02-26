import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// 11656 접미사 배열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i);
            set.add(tmp);
        }

        ArrayList<String> lists = new ArrayList<>(set);
        Collections.sort(lists);

        StringBuilder sb = new StringBuilder();
        for (String list : lists) {
            sb.append(list).append("\n");
        }
        System.out.print(sb);
    }
}