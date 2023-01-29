package KOI2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt(); //가로의 길이
        int h=sc.nextInt(); //세로의 길이

        int n=sc.nextInt(); //자르는 횟수

        boolean []ma=new boolean[m];
        boolean []ha=new boolean[h];

        for (int i=0;i<n;i++){
            //가로로 자르는 점선은 0과 점선 번호가 차례로 주어지고, 세로로 자르는 점선은 1과 점선 번호가 주어짐
            int x=sc.nextInt();
            int y=sc.nextInt();


            //해당 점선번호를 기준으로 구분
            if (x==0)
                ha[y]=true;

            else
                ma[y]=true;
        }

        int maxW=0;
        int tmp=0;

        //잘린 점선 번호를 만날 때까지 반복
        for (boolean b : ma) {
            if (b) {
                maxW = Math.max(tmp, maxW);
                tmp = 1;
            } else
                tmp += 1;
        }
        maxW=Math.max(maxW,tmp);

        tmp=0;
        int maxH=0;
        for (boolean b : ha) {
            if (b) {
                maxH = Math.max(tmp, maxH);
                tmp = 1;
            } else
                tmp += 1;
        }
        maxH=Math.max(maxH,tmp);

        System.out.println(maxH*maxW);
    }
}
