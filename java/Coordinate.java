import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Coordinate {
    public static void main(String[] args) {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n]; //원본 배열

        int[] b = new int[n]; //정렬할 배열

        for (int i = 0; i < n; i++) {
            b[i] = a[i] = sc.nextInt();
        }
        Arrays.sort(b);

        var h = new HashMap<Integer, Integer>(); //배열의 값에 해당하는 rank를 담는 Map

        int rank = 0; //좌표 압축시 우선순위 측정

        // 문제의 조건을 위한 조건 설정: 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

        for (int j : b) {

            if (!h.containsKey(j)) { //중복된 값이 들어오면 rank를 유지함(서로 같은 좌표이므로 개수 세지 않음)
                h.put(j, rank);
                rank += 1; //순서대로 정렬하였으므로 rank를 1씩 상승( Xi>Xj 조건, 서로 다른 좌표의 개수를 셈)
            }
        }

        //설정한 rank의 key에 해당하는 값을 출력
        StringBuilder sb = new StringBuilder();

        for (int j : a) {
            sb.append(h.get(j)).append(" ");
        }
        System.out.print(sb);
    }
}

