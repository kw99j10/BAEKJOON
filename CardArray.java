import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CardArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a); 
        /*
        문제 조건: 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다. -> 정렬필요
        */
        

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        int count = 1; //숫자가 나온 횟수 최소 1
        int max = 1; //배열에 있는 숫자는 적어도 1 이상이므로 최대값 변수 1 설정
        int maxIdx = 0; //max 변수의 위치

        /*
        정렬을 하였으므로 같은 수가 있다면 비교할 변수의 왼쪽에는 중복된 수가 있을 수 있다.
        따라서 카운팅을 하여 최댓값을 max에 대입하다가 다른 수가 나온다면 count를 1로 초기화한다.
         */
        for (int i = 1; i < a.length; i++) {

            if (a[i]==a[i-1])
                count += 1;

            else
                count = 1;

            if (count>max){
                max = count;
                maxIdx = i;
            }
        }
        System.out.println(a[maxIdx]);
    }
}
