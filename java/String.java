import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int result=a.length();
        //주어진 문자 a가 b의 문자열과 가장 많이 겹치는 부분을 고름 그 후에 값은 추가하면 되므로 신경쓰지 않음

        //문자열 차이만큼 반복문 실행(a 길이 만큼의 문자열이 b에 들어가야 하므로)

        for (int i=0;i<=b.length()-a.length();i++){

            int count=0;

            for (int j=0;j<a.length();j++){
                if (a.charAt(j)!=b.charAt(i+j)) //b 문자열의 시작 index를 1씩 옮김(증가 시킴)
                    count+=1;
            }
            System.out.println(result+" "+count);
            result=Math.min(result,count);
        }
        System.out.println(result);
    }
}
