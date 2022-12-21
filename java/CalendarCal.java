import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CalendarCal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt(); //지구를 나타내는 수
        int s = sc.nextInt(); //태양을 나타내는 수
        int m = sc.nextInt(); //달을 나타내는 수

        int count = 1;

        int i = 1, j = 1, k = 1;
        
        //입력으로 주어진 수 와 년도 수가 일치시 종료
        while (i != e || s != j || k != m) {

            i += 1;
            j += 1;
            k += 1;

            //어떤 수가 범위를 넘어가는 경우에는 1이 된다.
            //e의 범위 1~15, s의 범위 1~28 e의 범위 1~18
            if (i > 15)
                i = 1;

            if (j > 28)
                j = 1;

            if (k > 19)
                k = 1;

            count += 1;
        }
        System.out.println(count);
    }
}
