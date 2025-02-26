import java.io.IOException;
import java.util.*;

/**
 * baekjoon 17413 단어 뒤집기 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        var n=new Stack<Character>();

        StringBuilder sb=new StringBuilder();
        boolean k=false;

        for (int i=0;i<s.length();i++) {

            char c=s.charAt(i);

            if (c=='<') {
                k = true;

                while (!n.isEmpty())
                    sb.append(n.pop());

                sb.append(c);
            }
            else if (c=='>'){
                k=false;
                sb.append(c);
            }
            else if(k)
                sb.append(c);

            else {
                if (c==' '){
                    while (!n.isEmpty())
                        sb.append(n.pop());
                    sb.append(c);
                }
                else
                    n.push(c);
            }
        }
        while (!n.isEmpty())
            sb.append(n.pop());

        System.out.println(sb);
    }
}