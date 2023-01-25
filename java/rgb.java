import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * DP 기본 문제(탐색 가능한 모든 비용을 탐색)- 백준 1149 RGB 거리
 */
public class rgb {

    static int[][]cost; //색칠 유무를 탐색하는 배열
    static int [][]color; //색칠 유무를 탐색하는 배열 순서대로 빨,초,파

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cost=new int[n][3];
        color = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j]=sc.nextInt();
            }
        }
         /**
         * 주어진 색상 빨,초,파를 각각 0, 1, 2로 초기화 및 초기값 설정
         */
        color[0][0]=cost[0][0];
        color[0][1]=cost[0][1];
        color[0][2]=cost[0][2];

        System.out.println(Math.min((paint(n-1,0)),
                Math.min((paint(n-1,1)),paint(n-1,2))));
    }

    static int paint(int n,int c){

        //해당하는 배열의 값이 채워지지 않았을 경우
        if (color[n][c]==0){

            // 빨강색일 경우 초록색과 파랑색 중에 최소 값을 선택하여 더한다
            if (c==0)
                color[n][0]=Math.min(paint(n-1,1),paint(n-1,2))+cost[n][0];

            // 초록색일 경우 빨강색과 파랑색 중에 최소 값을 선택하여 더한다
            else if(c==1)
                color[n][1]=Math.min(paint(n-1,0),paint(n-1,2))+cost[n][1];

            // 파랑색일 경우 초록색과 빨강색 중에 최소 값을 선택하여 더한다
            else
                color[n][2]=Math.min(paint(n-1,0),paint(n-1,1))+cost[n][2];

        }
        return color[n][c];
    }
}
