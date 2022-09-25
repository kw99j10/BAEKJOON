import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*Scanner sc=new Scanner(System.in);*/

        int n= Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 
         /*StringBuilder 와 BufferReader()를 사용하면 실행시간을 크게 단축시킬 수 있음*/
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            /*StringTokenizer()로 한 문장라인을 받음*/
            String s=st.nextToken();
            /*nextToken()을 사용, "한 줄에서" 공백단위로 라인을 읽어들임*/
            /*여기서 push 123이면  처음 nextToken에서 push, 두번 째 nextToken에서 123을 받아들임*/
            if(s.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));

            if(s.equals("pop")) {

                if(stack.empty())
                    sb.append(-1).append("\n");

                else
                    sb.append(stack.pop()).append("\n");
            }

            if(s.equals("size"))
                sb.append(stack.size()).append("\n");

            if (s.equals("empty")) {

                if(stack.empty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }

            if(s.equals("top")) {
                if (stack.empty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
            }
        }
        System.out.print(sb);
    }
}






