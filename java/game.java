import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); //게임 횟수
        int y = sc.nextInt(); //이긴 게임

        int z = getPercent(y, x); //승률

        //게임 횟수의 범위 1 ~ 10억
        int start = 1;
        int end = (int) 1e9;

        //승률이 99이상이면 승률은 변할 수 없음
        if (z >= 99) {
            System.out.println(-1);
            return;
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;

            //판 수가 증가하면 승률도 증가: 최소 게임 횟수
            int score = getPercent(y + mid, x + mid);

            if (z >= score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }

    private static int getPercent(int y, int x) {
        return (int) ((long) y * 100 / x);
    }
}
