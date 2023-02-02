import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//가장 긴 증가하는 부분 수열 (LIS)+부분 수열 출력
public class Main {

    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int []a=new int[n]; //값 비교 배열
        int []seq=new int[n]; //최장 경로 탐색 배열

        for (int i=0;i<n;i++)
            a[i]=sc.nextInt();

        int ans = 1; //가장 긴 증가하는 부분 수열을 출력하기 위한 역추정 변수

        for (int i=0;i<n;i++){
            seq[i]=1; //값이 1을 두고 탐색 시작(경로를 생성)

            for (int j=0;j<i;j++){
                if (a[i]>a[j] && seq[j]+1>seq[i]){
                    seq[i]=seq[j]+1;
                    ans=Math.max(ans,seq[i]); //가장 긴 길이 리턴
                }
            }
        }
        //LIS
        //+ LIS의 부분 배열 출력 -->ans값을 바탕으로 역추적 시행
        int k=ans;
        
        //stack에 부분 배열을 역순으로 담음
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb=new StringBuilder();

        for (int i=n-1;i>=0;i--){
            if(k==seq[i]) {
                stack.push(a[i]);
                k-=1;
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        System.out.println(ans);
        System.out.println(sb);
    }
}
