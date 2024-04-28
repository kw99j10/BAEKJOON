import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> lists = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String s = br.readLine();

            if (lists.contains(s)) {
                lists.remove(s);
                lists.add(s);
            } else {
                lists.add(s);
            }
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String list : lists) {
            if (cnt >= k) {
                break;
            }
            sb.append(list).append("\n");
            cnt++;
        }
        System.out.print(sb);
    }
}