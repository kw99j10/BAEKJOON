import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//baekjoon 1193-bronze I -분수 찾기

public class SearchFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
      
        int i = 0;
        int count = 0; //1, 3, 6... 대각선 분수의 합
        /**
         * 각 대각선의 끝까지의 변수의 개수는 등차수열을 이룬다.
         */

        while (true) {
            i += 1;
            count += i;

             if (count >= x) { //x번째에 해당하는 분수 출력
                if (i % 2 == 0)
                    System.out.println((i - (count - x)) + "/" + (1 + (count - x)));

                else
                    System.out.println((1 + (count - x)) + "/" + (i - (count - x)));

                break;
            }
        }
    }
}
