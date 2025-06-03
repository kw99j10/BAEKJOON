import java.io.*;
import java.util.*;

// 28445 알록달록 앵무새
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> set = new ArrayList<>();

        String[] s1 = br.readLine().split(" ");
        ArrayList<String> lists = new ArrayList<>(Arrays.asList(s1));

        String[] s2 = br.readLine().split(" ");
        lists.addAll(Arrays.asList(s2));

        Collections.sort(lists);

        for (String l1 : lists) {
            for (String l2 : lists) {
                if (!set.contains(l1 + " " + l2)) {
                    set.add(l1 + " " + l2);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}