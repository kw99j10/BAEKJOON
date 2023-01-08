import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NumberWrite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 1;//자릿 수 (ex:count가 2이면 자릿수가 2자릿수가 들어옴)
        int tmp = 0; //새로운 수의 자릿 수
        int length = 10; //자릿 수 증가 표현 변수
        /**
         *  처음에는 자릿수가 1이다. i가 10일 때는 숫자의 자릿 수가 2이므로 count해준다.
         *  숫자의 자릿 수는 1~9, 10~99, 101~999 단위로  10의 배수마다 자릿 수가 증가한다.
         *  따라서 length의 초기 값은 10이다. 위에 따라 10, 100, 1000에 도달할 때마다 length에 10을 곱해준다.
         *  tmp 변수는 위의 규칙에 따라 변하는 count값인 자릿 수를 더해준다.
         */
        for (int i = 1; i <= n; i++) {

            if (i == length) {
                count += 1;
                length *= 10;
            }
            tmp += count;
        }
        System.out.println(tmp);
    }
}
