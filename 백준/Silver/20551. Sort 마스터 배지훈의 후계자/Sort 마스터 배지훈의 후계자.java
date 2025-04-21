import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 20551 Sort 마스터 배지훈의 후계자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(lists);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = lists.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (lists.get(mid) >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (lists.size() > left && lists.get(left) == num) {
                sb.append(left);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}