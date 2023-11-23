import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next(); //미르코가 본 양수 (최대 10만개의 숫자로 구성)

        //30의 배수 = 10의 배수 -> 10의 배수이면? "0"을 포함
        if (s.contains("0")) {
            int[] num = new int[s.length()]; //만들고 싶어하는 수를 출력할 배열

            int sum = 0;
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
                sum += num[i];
            }

            Arrays.sort(num);//가장 큰 수를 만들어야 하므로 배열을 정렬

            //30의 배수: 각 자릿수의 합이 3의 배수
            if (sum % 3 == 0) {
                for (int i = num.length - 1; i >= 0; i--) {
                    System.out.print(num[i]);
                }
            }

            //아닐 시 만들 수 있는 30의 배수가 존재하지 않음
            else{
                System.out.println(-1);
            }
        }

        //"0"이 없으면 30의 배수를 만들 수 없음
        else{
            System.out.println(-1);
        }

    }
}
