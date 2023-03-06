import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * baekjoon 1002 터렛
 *
 */
public class turret {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(circle(x1,y1,r1,x2,y2,r2)).append("\n");
        }
        System.out.print(sb);
    }
    static int circle(int x1,int y1,int r1, int x2, int y2,int r2){

        int distance= (int) (Math.pow((x1-x2),2)+Math.pow((y1-y2),2));

        /**
         * 총 경우의 수=두 원의 접점의 개수 -1(무한),0,1,2
         */

        //1. 두 좌표의 중심과 거리가 같음 -->접점 무한
        if (x1==x2 && y1==y2 && r1==r2)
            return -1;

        //2. 외접 또는 내접하지 않을 때-->접점 없음
        else if (distance>(r1+r2)*(r1+r2) || distance<(r1-r2)*(r1-r2))
            return 0;

        //3. 외접 또는 내접할 때 --> 접점 하나
        else if (distance==(r1+r2)*(r1+r2) || distance==(r1-r2)*(r1-r2))
            return 1;

        //4. 두 점에서 만날 때 -->접점 둘
        else
            return 2;
    }
}
