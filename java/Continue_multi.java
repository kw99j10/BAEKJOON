import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 2670 연속부분최대곱
 */
public class Continue_mult {
    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        double max = 0.0; 
        
        //연속적인 부분 곱을 구하는 배열을 생성 --> max 값 비교 위함
        double[] r = new double[n];

        for (int i = 0; i < n; i++) {

            if (i > 0) {
                r[i] = Math.max(a[i], a[i] * r[i - 1]);
            }
            //첫 항은 일치
            else
                r[i] = a[i];
        }

        for (double v : r)
            max = Math.max(v, max);

        System.out.printf("%.3f", max);
    }
}
