import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2331 반복수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(a);
        int before = a;

        int key;
        while (true) {
            String tmp = String.valueOf(before);

            int sum = 0;
            for (int i = 0; i < tmp.length(); i++) {
                int k = tmp.charAt(i) - '0';
                sum += (int) Math.pow(k, p);
            }
            if (lists.contains(sum)) {
                key = sum;
                break;
            }
            lists.add(sum);
            before = sum;
        }

        int count = 0;
        for (Integer num : lists) {
            if (key == num) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}