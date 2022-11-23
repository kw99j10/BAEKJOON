import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int []k=new int[n];
        for (int i=0;i<n;i++){
            k[i]=sc.nextInt();
        }

        int start = 0, end = 0, count = 0, sum = 0;

        while(end <= n) {

            if(sum == m)
                sum-=k[start++];
                // 현재까지 누적 합이 m과 같은 경우

            else if (sum < m) {
                if (end == n)
                    break;
                sum += k[end++];
                // 현재까지의 누적 합이 m보다 작은 경우
            }
            else
                sum-= k[start++];
                // 현재까지의 누적 합이 m보다 큰 경우

            if(sum==m)
                count++;
        }
        System.out.println(count);
    }
}






