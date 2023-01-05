import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//달팽이는 올라가고 싶다.
public class UPDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * Scanner 객체를 만드는 시간도 시간 제한에 걸릴 수 있음
         */
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //낮에 a 미터 올라감
        int b = Integer.parseInt(st.nextToken()); //밤에 b 미터 떨어짐
        int k = Integer.parseInt(st.nextToken()); //총 올라가야 하는 거리

        int distance=a-b; //하루동안 올라갈 수 있는 거리
        int sum=k-b; //k까지 도달해야 하는 거리의 합

        int days; //걸리는 일 수
        if (sum%distance==0)
            days=sum/distance;

        else
            days=sum/distance+1; //소수점 만큼의 거리가 남음

        System.out.println(days);
    }
}
