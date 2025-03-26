import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9440 숫자 더하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                break;
            }

            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            String s1 = "";
            String s2 = "";
            int count = 0;
            for (int i : arr) {
                if (i == 0) {
                    count++;
                    continue;
                }
                if (s1.length() <= s2.length()) {
                    s1 += i;
                } else {
                    s2 += i;
                }
            }

            for (int i = 0; i < count; i++) {
                if (s1.length() > s2.length()) {
                    s2 = s2.charAt(0) + "0" + s2.substring(1);
                } else if (s2.length() > s1.length()) {
                    s1 = s1.charAt(0) + "0" + s1.substring(1);
                } else {
                    if (s1.compareTo(s2) > 0) {
                        s2 = s2.charAt(0) + "0" + s2.substring(1);
                    } else {
                        s1 = s1.charAt(0) + "0" + s1.substring(1);
                    }
                }
            }
            sb.append(Integer.parseInt(s1) + Integer.parseInt(s2)).append("\n");
        }
        System.out.print(sb);
    }
}