import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 2089 -2진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> lists = new ArrayList<>();
        while (n != 0) {
            lists.add((int)Math.abs(n % (-2)));
            n = Math.ceil(n / (-2));
        }
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list);
        }
        System.out.print(sb.reverse());
    }
}