import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        var h = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String name=sc.next();
            String dd=sc.next();
            String mm=sc.next();
            String yy=sc.next();

            if(dd.length()==1)
                dd="0"+dd;

            if(mm.length()==1)
                mm="0"+mm;

            String k=yy+mm+dd;

            int t = Integer.parseInt(k);
            h.put(name, t);
        }
        //map내에서 value or key 대소비교 --> value에 대한 key 값 출력(max, min)
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();

        Map.Entry<String, Integer> maxEntry = Collections.max(h.entrySet(), comparator);
        Map.Entry<String, Integer> minEntry = Collections.min(h.entrySet(), comparator);
        System.out.println(maxEntry.getKey());
        System.out.println(minEntry.getKey());
    }
}






