import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*Scanner sc = new Scanner(System.in);*/

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        var t = new HashSet<Integer>();
        var s = new HashSet<Integer>();
        
        /*줄 바꾸면서 입력시 공백단위로 입력 위해 필요*/
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<a;i++)
            t.add(Integer.parseInt(st.nextToken()));

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<b;i++)
            s.add(Integer.parseInt(st.nextToken()));

        int count = 0;
        /*hashse 다른 집합간 비교 용이*/
        for (int i : t) {

            if (!s.contains(i))
                count += 1;
        }

        for (int i : s) {

            if (!t.contains(i))
                count += 1;
        }
        System.out.println(count);
    }
}






