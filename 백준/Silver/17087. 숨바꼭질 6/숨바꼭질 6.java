import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 17087 숨바꼭질 6
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(Math.abs(Integer.parseInt(st.nextToken()) - s));
        }

        int max = lists.get(0);
        for (int i = 1; i < n; i++) {
            max = gcd(max, lists.get(i));
        }
        System.out.println(lists.size() == 1 ? lists.get(0) : max);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}