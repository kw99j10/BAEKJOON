import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1138 한 줄로 서기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] left = new int[n + 1]; //자신보다 큰 사람이 왼 쪽에 몇명 있었는지

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            list.add(left[i], i);
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}