import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  //baekjoon 1025-ACM Hotel//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < t; i++) {

            int h = sc.nextInt(); //높이
            int w = sc.nextInt(); //너비
            int n = sc.nextInt(); //몇번째 손님

            //호수 구하기
            int sum=100;
            int[][] a = new int[h][w];

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    a[j][k] = sum + (k + 1);
                }
                sum+=100;
            }

            //엘리베이터에서 호수까지의 거리 구하기
            int dis=1;
            int [][]b=new int[h][w];

            for (int j=0;j<h;j++) {
                for (int k = 0; k < w; k++) {
                    b[j][k] = dis + k;
                }
            }

            //정해진 호수에는 더이상 손님을 넣지 않기-초기값 false
            boolean [][]c=new boolean[h][w];


            //n까지의 최소값 구하기(우선 X01호에 손님들을 채움)-->최소한의 거리 순서
            int count=0;

            int j=0;
            int k=0;

            while (true) {

                //배열은 0번부터이므로 n-1이되면 종료, 즉 10번째 손님이면 9번째 index에서 종료
                if (count==n-1){
                    sb.append(a[j][k]).append("\n");
                    break;
                }

                c[j][k]=true;
                count += 1;

                //높이를 다 채웠다면 옆으로 호수를 한칸씩 옮김
                if (j==h-1) {
                    j = 0;
                    k += 1;
                }

                //아니면 그 높이를 계속 증가
                else
                    j+=1;
            }
        }
        System.out.print(sb);
    }
}
