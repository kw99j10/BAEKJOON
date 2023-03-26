import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * baekjoon 1874 스택 수열
 *
 */
public class stackArray {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        var s = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        //1~n까지 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 함.

        int ans = 0; //오름차순 비교 변수

        for (int i = 0; i < n; i++) {

            int k = sc.nextInt(); //입력한 변수

            //입력한 변수가 기존 값보다 클 때 push(오름차순 push)
            if (k > ans) {
                for (int j = ans + 1; j <= k; j++) {

                    s.push(j);
                    sb.append("+").append("\n");
                }
                //다음 변수가 지금 입력된 변수보다 큰지 안큰지를 비교하기 위함
                ans = k;
            }
            
            //입력한 변수가 맨 위의 변수가 아니라면 입력된 순서대로 수열을 만들 수 없음을 의미함
            else if (s.peek()!=k){
                System.out.println("NO");
                return;
            }

            s.pop();
            sb.append("-").append("\n");
        }
        System.out.print(sb);
    }
}
