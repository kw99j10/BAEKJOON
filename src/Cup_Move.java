import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Cup_Move {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        var ar= new ArrayList<>(Arrays.asList("O", "X", "X")); //공이 들어있는 컵을 "O"라고 하자

        String s=sc.next();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)=='A')
                Collections.swap(ar,0,1);

            else if(s.charAt(i)=='B')
                Collections.swap(ar,1,2);

            else if(s.charAt(i)=='C')
                Collections.swap(ar,0,2);
        }
        System.out.println(ar.indexOf("O")+1); //List의 index 번호는 0부터 시작하므로
    }
}


