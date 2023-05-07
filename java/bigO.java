import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 24368 점근적 표기 4
 *
 */
public class bigO {
    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int a2 = sc.nextInt();
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();

        int c = sc.nextInt();
        int n = sc.nextInt();

        int result1 = (int) (c * Math.pow(n, 2));
        int result2 = (int) (a2 * Math.pow(n, 2) + a1 * n + a0);

        //이차 함수의 판별식
        double result = a1 * a1 - 4 * (a2 - c) * a0;

        //판별식이 0보다 작거나 같은 경우 교점이 0개 or 1개
        if (c == a2 || result <= 0) {
            System.out.println(result1 >= result2 ? 1 : 0);
        }

        //판별식이 0보다 크면 교점이 2개(작아지는 구간이 존재함)
        else {
            double k = Math.sqrt(result);

            double ans1 = (-a1 + k) / (2 * (a2 - c));
            double ans2 = (-a1 - k) / (2 * (a2 - c));

            //교점 중에 큰 값보다 n이 크거나 같으면 빅오 표기법 만족
            double ans = Math.max(ans1, ans2);

            System.out.println((n >= ans) && (result1 >= result2) ? 1 : 0);
        }
    }
}
