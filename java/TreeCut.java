import java.util.Arrays;
import java.util.Scanner;

// 나무자르기
public class Main {

    static int[] arr; //나무를 담을 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //나무의 수
        int m = sc.nextInt(); //필요한 나무의 길이

        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //이분 탐색을 위한 정렬
        //ex)10, 15, 17, 20

        //탐색 범위 시작은 0, 끝은 배열의 마지막 요소
        int start = 0;
        int mid = 0;
        int end = arr[arr.length - 1];

        long sum;
        while (start <= end) {

            mid = (start + end) / 2;

            sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid); //mid 값 보다 높으면 나무를 자름
                }
            }
            //자른 나무의 합이 m보다 크거나 같다면
            //생각한 길이보다 더 많은 나무를 잘랐으므로 mid 값이 더 클 것
            //따라서 시작 범위를 증가시킴

            if (sum >= m) {
                start = mid + 1;
            }

            //자른 나무의 합이 m보다 작다면
            //나무가 많이 안 잘렸으므로 mid 값이 더 작을 것
            //따라서 종료 범위를 감소시킴
            else{
                end = mid - 1;
            }
            System.out.println(mid + " " + start + " " + end);
        }
        System.out.println(end);
    }
}
