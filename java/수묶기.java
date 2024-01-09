import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //수를 적절히 묶기 위해 양수 리스트와 음수 리스트를 만듦
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();

        int zero = 0; //0의 개수를 셈
        int sum = 0; //구할 최대 합

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();

            if (tmp == 0) {
                zero += 1;
            } else if (tmp == 1) {
                sum += tmp; //1은 더하는 게 더 큼 (1+1)>(1*1)
            } else if (tmp > 0) {
                p.add(tmp);
            } else {
                m.add(tmp);
            }
        }

        //만약 리스트가 홀수라면
        // 양수 -> 1을 더함 (리스트에는 1이 없으므로 값의 변화 X),
        // 음수 -> 0이 있다면 0을 더함 아니면 1을 더함 (음수는 0을 곱한 것이 더 크므로)

        if (p.size() % 2 != 0) {
            p.add(1);
        }
        if (m.size() % 2 != 0) {
            m.add(zero > 0 ? 0 : 1);
        }

        Collections.sort(m);
        Collections.sort(p);
        Collections.reverse(p); //최대 합을 출력하기 위한 정렬

        for (int i = 0; i < p.size(); i += 2) {
            sum += p.get(i) * p.get(i + 1);
        }
        for (int i = 0; i < m.size(); i += 2) {
            sum += m.get(i) * m.get(i + 1);
        }
        System.out.println(sum);
    }
}
