import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16953 A -> B
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        while (true) {

            if (a >= b) {
                break;
            }

            if (b % 10 == 1) {
                b = b / 10;
            } else if (b % 2 == 0) {
                b = b / 2;
            } else {
                break;
            }
            count++;
        }
        System.out.println(b == a ? count + 1 : -1);
    }
}