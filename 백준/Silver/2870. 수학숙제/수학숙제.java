import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

// 2870 수학숙제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            String tmp = "";
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= '0' && c <= '9') {
                    tmp += c;
                } else if (!tmp.isEmpty() && c >= 'a' && c <= 'z') {
                    lists.add(new BigInteger(tmp));
                    tmp = "";
                }
            }

            if (!tmp.isEmpty()) {
                boolean isPossible = true;
                for (int j = 0; j < tmp.length(); j++) {
                    if (tmp.charAt(j) >= 'a' && tmp.charAt(j) <= 'z') {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    lists.add(new BigInteger(tmp));
                }
            }
        }

        Collections.sort(lists);
        StringBuilder sb = new StringBuilder();
        for (BigInteger list : lists) {
            sb.append(list).append("\n");
        }
        System.out.print(sb);
    }
}