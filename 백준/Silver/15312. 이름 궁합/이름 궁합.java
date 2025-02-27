import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15312 이름 궁합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            tmp.append(a.charAt(i));
            tmp.append(b.charAt(i));
        }

        StringBuilder num = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            num.append(alpha[tmp.charAt(i) - 65]);
        }

        while (num.length() > 2) {

            tmp = new StringBuilder();
            for (int i = 0; i < num.length() - 1; i++) {
                int n1 = num.charAt(i) - '0';
                int n2 = num.charAt(i + 1) - '0';
                int answer = (n1 + n2) % 10;
                tmp.append(answer);
            }
            num = new StringBuilder(tmp.toString());
        }
        System.out.println(num.length() == 1 ? "0" + num : num.toString());
    }
}