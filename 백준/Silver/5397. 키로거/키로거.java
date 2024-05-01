import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            String s = br.readLine();
            LinkedList<Character> lists = new LinkedList<>();
            ListIterator<Character> list = lists.listIterator();
            for (char c : s.toCharArray()) {

                if (c == '<') {
                    if (list.hasPrevious()) {
                        list.previous();
                    }
                } else if (c == '>') {
                    if (list.hasNext()) {
                        list.next();
                    }
                } else if (c == '-') {
                    if (list.hasPrevious()) {
                        list.previous();
                        list.remove();

                    }
                } else {
                    list.add(c);
                }
            }
            for (Character c : lists) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}