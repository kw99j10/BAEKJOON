import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 1654 랜선 자르기
 *
 */
public class lens {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        //가지고 있는 랜선의 개수 k, k개를 이용하여 만들 랜선의 개수 n
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] a = new long[k];

        //최대 길이의 랜선을 구함(나누는 기준 값)
        long max = 0;

        for (int i = 0; i < k; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        //길이가 1,1인 랜선이 주어지면 mid의 값이 0이될 수 있으므로
        max += 1;

        //이분탐색 변수
        long mid = 0;
        long min = 0;

        while (min < max) {

            //중간 길이
            mid = (min + max) / 2;

            //중간 길이로 잘랐을 때 구할 수 있는 랜선의 개수
            long count = 0;
            
            for (long l : a) {
                count += l / mid;
            }
            //랜선의 개수가 주어진 값보다 작다면 max의 값을 줄여 count의 값을 늘리고
            if (count < n) {
                max = mid;
            }
            //랜선의 개수가 주어진 값보다 커지면 min에 값을 넣어 count의 값을 줄인다.
            else
                min = mid + 1;
        }
        System.out.println(min - 1);
    }
}
