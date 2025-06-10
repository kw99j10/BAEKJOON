import java.io.*;
import java.util.*;

// 20437 문자열 게임 2
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] lists = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < s.length(); i++) {
                lists[s.charAt(i) - 'a'].add(i); // 문자가 나온 인덱스
            }

            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < 26; i++) {
                ArrayList<Integer> tmp = lists[i];
                if (k > tmp.size()) {
                    continue; // k개 이상 포함해야함
                }

                for (int j = 0; j <= tmp.size() - k; j++) {
                    int len = tmp.get(j + k - 1) - tmp.get(j) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }


            if (min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.print(sb);
    }
}