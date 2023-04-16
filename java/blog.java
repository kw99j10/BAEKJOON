import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * baekjoon 21921 블로그
 *
 */
public class blog {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long []a=new long[n];

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());

        long sum=0;

        for (int i=0;i<x;i++)
            sum+=a[i];

        long max=sum;
        int count=1;

        for (int i=x;i<n;i++){
            //슬라이딩 윈도우: 기존의 합에서 양 끝의 값의 차를 더한다. ==>들어온 값을 더하고 빠지는 값을 빼준다.
            //if( a[0]=1, a[1]=2, a[2]=3, a[3]=4 일 때 a[1]+a[2]= sum(a[0]+a[1])+(a[2]-a[1])
            sum+=a[i]-a[i-x];
            if (sum>max) {
                max=sum;
                count = 1;
            }
            else if(sum==max)
                count+=1;
        }
        if (max==0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
