import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //집의 개수
        int c = sc.nextInt(); //공유기의 개수

        int[] modem = new int[n];
        for (int i = 0; i < n; i++) {
            modem[i] = sc.nextInt();
        }

        Arrays.sort(modem); //이분 탐색을 위한 정렬

        //탐색 범위 시작은 1: 공유기의 최소 거리, 끝은 배열의 마지막 요소
        long start = 1;
        long mid = 0;
        long end = modem[modem.length - 1];

        int count; //필요한 공유기의 개수

        while (start <= end) {
            mid = (start + end) / 2;

            /**
             * 이전 집과 현재 집 좌표의 거리를 비교하여 공유기 개수 증가
             */
            count = 1; //첫 집에 공유기 설치

            int tmp = modem[0];
            for (int i = 1; i < modem.length; i++) {
                if (modem[i] - tmp >= mid) {
                    count += 1;
                    tmp = modem[i];
                }
            }

            //필요한 공유기 개수와 주어진 공유기 개수 비교
            if (count >= c) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
