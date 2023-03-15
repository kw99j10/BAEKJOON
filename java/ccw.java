import java.io.IOException;
import java.util.Scanner;

/**
 * baekjoon 11758 CCW- 기하학
 *
 */
public class ccw {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int x1=sc.nextInt();
        int y1=sc.nextInt();

        int x2=sc.nextInt();
        int y2=sc.nextInt();

        int x3=sc.nextInt();
        int y3=sc.nextInt();

        /**
         * 신발끈 공식 -결과값이 0보다 크면 반시계 방향, 0이면 일직선, 0보다 작으면 시계 방향
         */
        int result=x1*y2+x2*y3+x3*y1-(x2*y1+x3*y2+x1*y3);

        //시계방향일 경우
        if (result<0)
            System.out.println(-1);

        //평행일 경우
        else if (result==0)
            System.out.println(0);

        //반시계방향
        else
            System.out.println(1);
    }
}
