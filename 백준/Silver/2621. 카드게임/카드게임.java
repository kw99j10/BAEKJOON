import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 2621 카드게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean same = true;
        ArrayList<Integer> lists = new ArrayList<>();

        String before = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        lists.add(num);

        for (int i = 1; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String current = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (!before.equals(current)) {
                same = false;
            } else {
                before = current;
            }
            lists.add(n);
        }

        boolean continuous = true;
        Collections.sort(lists);
        int b = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            int c = lists.get(i);
            if (b + 1 != c) {
                continuous = false;
                break;
            }
            b = c;
        }

        int[] number = new int[10];
        for (Integer list : lists) {
            number[list]++;
        }

        boolean isFour = false;
        boolean isThree = false;
        boolean isTwo = false;
        boolean isTwoS = false;
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        for (int i = 1; i <= 9; i++) {
            if (number[i] == 4) {
                isFour = true;
                idx = i;
            }

            if (number[i] == 3) {
                isThree = true;
                idx1 = i;
            }

            if (number[i] == 2) {
                if (isTwo) {
                    isTwoS = true;
                    idx3 = i;
                } else {
                    isTwo = true;
                    idx2 = i;
                }
            }
        }

        // 1. 카드 5장 모두 같은 색 && 모두 연속 숫자일 때 점수는 가장 높은 숫자에 900을 더함
        if (same && continuous) {
            System.out.println(lists.get(lists.size() - 1) + 900);
        }

        // 2. 카드 5장 중 4장의 숫자가 같으면 같은 숫자에 800을 더함
        else if (isFour) {
            System.out.println(idx + 800);
        }

        // 3. 카드 5장 중 3장 숫자 같고 나머지 2장 숫자 같다면 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자와 700을 더함
        else if (isThree && isTwo) {
            System.out.println(idx1 * 10 + idx2 + 700);
        }

        // 4. 5장의 카드 색이 모두 같으면 가장 높은 숫자에 600을 더함
        else if (same) {
            System.out.println(lists.get(lists.size() - 1) + 600);
        }

        // 5. 카드 5장 숫자가 연속적이면 가장 높은 숫자에 500을 더함
        else if (continuous) {
            System.out.println(lists.get(lists.size() - 1) + 500);
        }

        // 6. 카드 5장 중 3장 숫자 같을 때 같은 숫자에 400을 더함
        else if (isThree) {
            System.out.println(idx1 + 400);
        }

        // 7. 카드 5장 중 2장 숫자가 같고 또 다른 2장 숫자가 같을 때 큰 숫자에 10을 곱하고 같은 숫자중 작은 숫자와 300을 더함
        else if (isTwo && isTwoS) {
            System.out.println(idx3 * 10 + idx2 + 300);
        }

        // 8. 카드 5장 중 2장 숫자 같을 때 같은 숫자에 200을 더함
        else if (!isTwoS && isTwo) {
            System.out.println(idx2 + 200);
        }

        // 9. 모두 아니라면 가장 큰 숫자에 100을 더함
        else {
            System.out.println(lists.get(lists.size() - 1) + 100);
        }
    }
}