import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 16198 에너지 모으기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> lists = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lists.add(Integer.parseInt(st.nextToken())); // 에너지 구슬을 담은 리스트
        }

        int max = getMax(lists);
        System.out.println(max);
    }

    private static int getMax(ArrayList<Integer> lists) {

        if (lists.size() == 2) {
            return 0; // 종료 조건
        }

        int max = 0;
        for (int i = 1; i < lists.size() - 1; i++) {

            ArrayList<Integer> tmp = new ArrayList<>(lists);
            int sum = tmp.get(i - 1) * tmp.get(i + 1);
            tmp.remove(i);
            max = Math.max(max, getMax(tmp) + sum);
        }
        return max;
    }
}