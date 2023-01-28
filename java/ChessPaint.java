import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChessPaint {

    /**
     * 브루트 포스 알고리즘
     */
    static String [][]chess;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        chess = new String[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] st = s.split("");
            System.arraycopy(st, 0, chess[i], 0, st.length);
        }

        int ans=64;//8*8크기 이므로 63개가 최대 수정값이라고 설정

        //8*8 크기를 갖는 체스판을 구하는 탐색 알고리즘
        for (int i=0;i<n-7;i++){
            for (int j=0;j<m-7;j++){
                ans=Math.min(ans,find(i,j));
            }
        }
        System.out.println(ans);
    }
    //8*8 체스판 중 최소 변경 값을 갖는 체스판의 최소 변경 값 return
    static int find(int n,int m){

        //체스판의 경우의 수는 검은색으로 시작하거나 흰색으로 시작하거나 2가지 경우의 수를 가진다.

        int B_count=0; //체스판이 B부터 시작할 때 바꾸어여 할 정사각형의 수 B->W
        int W_count=0; //체스판이 W부터 시작할 때 바꾸어야 할 정사각형의 수 W->B

        for (int i=n;i<n+8;i++){
            for (int j=m;j<m+8;j++){
                if((i + j) % 2 == 0) { //(0부터 시작한다고 가정) 짝수행 짝수 열 또는 홀수행 홀수 열 일 때
                    //B부터 시작하므로 해당 칸에는 B만 칠해 져야 하는데 W가 칠해져 있는 경우
                    if(chess[i][j] .equals("W"))
                        B_count+=1;
                    else
                        W_count+=1;
                }else { // (i + j) % 2 == 1)
                    if(chess[i][j] .equals("B"))
                        B_count+=1;
                    else
                        W_count+=1;
                }
            }
        }
        return Math.min(B_count,W_count);
    }
}
