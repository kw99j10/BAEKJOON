import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poliomino {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='X') //X가 나올 경우 count를 증가
                count += 1;

            else{ //X가 아니면 .이 나온 경우인데 이 때 count가 홀수이면 X의 개수가 홀수라는 소리이므로 break
                if (count % 2 != 0) {
                    sb=new StringBuilder();
                    sb.append(-1);
                    break;
                }
                //X가 짝수일 경우만 반복문 실행
                while (count != 0) {

                    if (count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    }
                    else {
                        sb.append("BB");
                        count -= 2;
                    }
                }
                sb.append(".");
            }
        }

        //. 없이 X만 이어서 나올 경우 count가 초기화 되지 않으므로...
        if (count>0){
            if (count%2!=0) {
                sb=new StringBuilder();
                sb.append(-1);
            }
            else{
                while (count != 0) {

                    if (count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    }
                    else {
                        sb.append("BB");
                        count -= 2;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
