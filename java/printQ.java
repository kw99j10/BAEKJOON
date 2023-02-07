import java.io.IOException;
import java.util.*;

/**
 * baekjoon 1966 프린터 큐
 */

public class printQ {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); //test case 수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt(); //문서의 개수
            int m = sc.nextInt(); //몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수

            LinkedList<int []>a= new LinkedList<>(); //n개의 수를 담을 큐

            for (int j = 0; j < n; j++) {
                int p = sc.nextInt();
                a.add(new int[]{j,p});
            }
            //ex(n=4, m=2 일 때 입력값이 1,2,3,4로 들어올 시 [0, 1] [1, 2] [2, 3] [3, 4] 형태로 저장 [인덱스,우선순위]꼴

            int count = 0;
            while (!a.isEmpty()) {

                int []ans=a.poll(); //저장된 값이 한 쌍씩 들어옴
                boolean b=true; //큐의 첫 원소가 max값인지를 판단


                for (int j = 0; j < a.size(); j++) {

                    //우선순위간의 비교로 기존 우선순위가 맨 앞의 우선순위보다 크다면 해당 수를 뒤로 보냄 이는 max가 아니므로 break
                    if (a.get(j)[1]>ans[1]){
                        a.offer(ans);

                        for (int k=0;k<j;k++)
                            a.offer(a.poll());

                        b=false;
                        break;
                    }
                }
                //max값이 아니므로 반복 실행
                if (!b)
                    continue;

                else
                    count+=1;

                //처음에 남아있는 수의 index가 m과 일치하면 반복문을 탈출
                if (ans[0]==m)
                    break;

            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
