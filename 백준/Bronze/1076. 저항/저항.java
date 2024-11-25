import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] mul = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < color.length; i++) {
            if (c1.equals(color[i])) {
                answer.append(num[i]);
            }
        }
        for (int i = 0; i < color.length; i++) {
            if (c2.equals(color[i])) {
                answer.append(num[i]);
            }
        }

        long ans = Integer.parseInt(answer.toString());
        for (int i = 0; i < color.length; i++) {
            if (c3.equals(color[i])) {
                ans *= mul[i];
            }
        }

        System.out.print(ans);
    }
}