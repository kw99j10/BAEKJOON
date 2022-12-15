import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Base_Conversation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        int a = sc.nextInt(); //미래 세계에서 사용하는 진법 a
        int b = sc.nextInt(); //정이가 사용하는 진법 b

        int m = sc.nextInt(); //a진법으로 나타낸 숫자의 자릿 수

        int []arr=new int[m]; //m을 이루는 수 들을 담을 배열(m의 자릿 수만큼 생성)

        StringBuilder sb=new StringBuilder();

        int t=0; //a진수->10진수->b진수 순으로 변환
        for (int i = 0; i < m; i++) {
            arr[i]=sc.nextInt();
            t+=arr[i]*Math.pow(a,m-(i+1));
        }
        var s=new Stack<Integer>(); //stack 이용(역순으로 출력)

        while (t!=0){
            s.push(t%b);

            t/=b;
        }
        while (!s.isEmpty()){

            if (s.size()==1)
                sb.append(s.peek());

            else
                sb.append(s.peek()).append(" ");

            s.pop();
        }
        System.out.println(sb);
    }
}






