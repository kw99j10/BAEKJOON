import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 2635 수 이어가기
public class Main {
    static int n, max, maxIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = n; i >= n / 2; i--) {
            find(i);
        }

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(n);
        lists.add(maxIdx);

        int a1 = n;
        int a2 = maxIdx;
        while (true) {
            int tmp = a1 - a2;
            if (tmp < 0) {
                break;
            }
            lists.add(tmp);
            a1 = a2;
            a2 = tmp;
        }

        System.out.println(lists.size());
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list).append(" ");
        }
        System.out.print(sb);
    }

    static void find(int x) {

        int cnt = 0;

        int a1 = n;
        int a2 = x;
        while (true) {
            int tmp = a1 - a2;
            if (tmp < 0) {
                break;
            }
            a1 = a2;
            a2 = tmp;
            cnt++;
        }

        if (cnt > max) {
            max = cnt;
            maxIdx = x;
        }
    }
}