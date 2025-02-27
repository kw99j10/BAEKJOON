import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1541 잃어버린 괄호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "-");
        int answer = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            int sum = 0;
            while (st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }

            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}