import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3107 IPv6
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = new String[8];
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 2번 적용 x
        if (!s.contains("::")) {
            st = s.split(":");
            for (int i = 0; i < 8; i++) {
                sb.append("0".repeat(Math.max(0, 4 - st[i].length())));
                sb.append(st[i]);

                if (i < 7) {
                    sb.append(":");
                }
            }
        }

        // 2번 적용 o
        else {
            String[] tmp = s.split(":");
            if (s.endsWith("::")) {
                int start = 0;
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].isEmpty()) {
                        break;
                    }
                    st[start] = tmp[i];
                    start++;
                }
                for (int i = 0; i < start; i++) {
                    st[i] = "0".repeat(Math.max(0, 4 - st[i].length())) + st[i];
                }
                for (int i = start; i < 8; i++) {
                    st[i] = "0000";
                }
            } else {
                int start = 0;
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].isEmpty()) {
                        break;
                    }
                    st[start] = tmp[i];
                    start++;
                }

                int end = 7;
                for (int i = tmp.length - 1; i >= 0; i--) {
                    if (tmp[i].isEmpty()) {
                        break;
                    }
                    st[end] = tmp[i];
                    end--;
                }
                for (int i = 0; i < start; i++) {
                    st[i] = "0".repeat(Math.max(0, 4 - st[i].length())) + st[i];
                }
                for (int i = start; i <= end; i++) {
                    st[i] = "0000";
                }
                for (int i = end + 1; i < 8; i++) {
                    st[i] = "0".repeat(Math.max(0, 4 - st[i].length())) + st[i];
                }
            }
            for (int i = 0; i < st.length; i++) {
                sb.append(st[i]);
                if (i < st.length - 1) {
                    sb.append(":");
                }
            }
        }
        System.out.print(sb);
    }
}