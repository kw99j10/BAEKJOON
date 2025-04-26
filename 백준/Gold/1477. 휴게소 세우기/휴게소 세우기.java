import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 1477 휴게소 세우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(0);
        list.add(l); // 0 ~ l 까지의 휴게소
        Collections.sort(list);

        int start = 1; // zero 오류
        int end = l - 1;
        while (start <= end) {
            int mid = (start + end) / 2; // 간격의 기준

            int count = 0; // 휴게소 개수
            for (int i = 1; i < list.size(); i++) {
                int d = list.get(i) - list.get(i - 1);
                count += d / mid;
                if (d % mid == 0) {
                    count--; // 중복 방지
                }
            }

            if (m >= count) {
                end = mid - 1;
            } else {
                start = mid + 1; // 휴게소를 다 세울 수 없으므로 휴게소를 세울 간격을 늘림
            }
        }
        System.out.println(start);
    }
}