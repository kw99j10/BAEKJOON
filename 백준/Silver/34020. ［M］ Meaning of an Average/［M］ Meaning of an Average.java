import java.io.*;
import java.util.*;

// 34020
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> lists = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lists.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lists);
        double sum = lists.pollFirst();
        while (!lists.isEmpty()) {
            sum += lists.pollFirst();
            sum /= 2;
        }
        System.out.println(sum);
    }
}