import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 2696 중앙값 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num + 1];

            StringTokenizer st;
            int idx = 1;
            while (idx <= num) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(num / 2 + 1).append("\n");
            LinkedList<Integer> queue = new LinkedList<>();
            int cnt = 0;
            for (int i = 1; i <= num; i++) {
                queue.add(arr[i]);
                Collections.sort(queue);
                if (i % 2 != 0) {
                    sb.append(queue.get(queue.size() / 2)).append(" ");
                    cnt++;
                    if (cnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
