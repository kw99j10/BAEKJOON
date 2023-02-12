import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * baekjoon 2512 예산
 */

public class Budget {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //int max=0;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            //max=Math.max(max,a[i]);
        }
        Arrays.sort(a); //예산 내 최댓값 구하기 위한 정렬

        int m = sc.nextInt();//총 예산을 나타내는 정수 M
        //이분 탐색 중앙값을 구하기 위한 변수
        int left=0;
        
        //int right=max;
        int right=a[n-1];

        while (left <= right) {

            int mid = (left + right) / 2;
            long sum=0L;

            for (int i = 0; i < n; i++) {
                sum += Math.min(a[i], mid);
            }
            if (sum <= m)
                left = mid + 1;

            else
                right = mid - 1;
        }
        System.out.println(right);
    }
}
