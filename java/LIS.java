import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//가장 긴 증가하는 부분 수열 (LIS)
public class LIS {

    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int []a=new int[n]; //값 비교 배열
        int []seq=new int[n]; //최장 경로 탐색 배열

        for (int i=0;i<n;i++)
            a[i]=sc.nextInt();

        for (int i=0;i<n;i++){
            seq[i]=1; //값이 1을 두고 탐색 시작(경로를 생성)

            for (int j=0;j<i;j++){
                if (a[i]>a[j] && seq[j]+1>seq[i])
                    seq[i]=seq[j]+1;
            }
        }
        Arrays.sort(seq);
        System.out.println(seq[seq.length-1]);
    }
}

