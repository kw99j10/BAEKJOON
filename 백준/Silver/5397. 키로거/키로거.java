import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int idx = 0;
            String s = br.readLine();
            LinkedList<Character> lists = new LinkedList<>();
            for (char c : s.toCharArray()) {
               
                if (c == '<') {
                    if (idx > 0) {
                        idx--;
                    }
                } else if (c == '>') {
                    if (lists.size() > idx) {
                        idx++;
                    }
                } else if (c == '-') {
                    if (idx > 0) {
                        lists.remove(idx - 1);
                        idx--;
                    }
                } else {
                    lists.add(idx, c);
                    idx++;
                }
            }
            for (Character list : lists) {
                sb.append(list);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
