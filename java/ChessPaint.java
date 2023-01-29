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
    static int find(int x, int y) {

        int paintB = 0; //B부터 시작하는 체스판일 때 다시 칠해야 하는 사각형의 수 W->B
        int paintW = 0; //W부터 시작하는 체스판일 때 다시 칠해야 하는 사각형의 수 B->W

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) { //짝수번째 짝수열 또는 홀수번째 홀수열인 경우
                    if (chess[i][j].equals("W")) { //B부터 체스판을 시작
                        paintB += 1;
                    }
                    else //W부터 체스판을 시작
                        paintW += 1;
                }
                else{   //짝수번째 홀수열 또는 홀수번째 짝수열인 경우
                    if (chess[i][j].equals("B")) { //B부터 체스판을 시작
                        paintB += 1;
                    }
                    else //W부터 체스판을 시작
                        paintW += 1;
                }
            }
        }
        return Math.min(paintW, paintB);
    }
}
