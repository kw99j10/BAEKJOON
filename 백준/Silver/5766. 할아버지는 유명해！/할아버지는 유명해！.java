import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 5766 할아버지는 유명해!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int[] player = new int[10001];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    player[tmp] += 1;
                }
            }

            int max = 0;
            for (int i = 1; i <= 10000; i++) {
                if (player[i] > max) {
                    max = player[i];
                }
            }

            int second = 0;
            for (int i = 1; i <= 10000; i++) {
                if (max > player[i] && player[i] > second) {
                    second = player[i];
                }
            }

            ArrayList<Integer> lists = new ArrayList<>();
            for (int i = 1; i <= 10000; i++) {
                if (player[i] == second) {
                    lists.add(i);
                }
            }

            for (Integer list : lists) {
                sb.append(list).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}