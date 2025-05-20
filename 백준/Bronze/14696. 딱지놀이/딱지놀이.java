import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 14696 딱지놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int num2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num2; j++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            if (a.size() > b.size()) {
                for (int j = 0; j < a.size() - b.size(); j++) {
                    b.add(0);
                }
            } else if (b.size() > a.size()) {
                for (int j = 0; j < b.size() - a.size(); j++) {
                    a.add(0);
                }
            }

            Collections.sort(a);
            Collections.sort(b);

            boolean isA = false;
            boolean isB = false;
            for (int j = a.size() - 1; j >= 0; j--) {
                int ansA = a.get(j);
                int ansB = b.get(j);

                if (ansA > ansB) {
                    isA = true;
                    break;
                } else if (ansB > ansA) {
                    isB = true;
                    break;
                }
            }

            if (isA) {
                sb.append("A").append('\n');
            } else if (isB) {
                sb.append("B").append('\n');
            } else {
                sb.append("D").append('\n');
            }
        }
        System.out.print(sb);
    }
}