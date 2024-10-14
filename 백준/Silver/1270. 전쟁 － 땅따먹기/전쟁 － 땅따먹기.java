import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1270 전쟁 - 땅따먹기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Long, Integer> map = new HashMap<>();
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                long land = Long.parseLong(st.nextToken());
                map.put(land, map.getOrDefault(land, 0) + 1);
            }
            ArrayList<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());

            long firstKey = 0;
            int firstValue = 0;
            for (Map.Entry<Long, Integer> entry : list) {
                firstKey = entry.getKey();
                firstValue = entry.getValue();
                break;
            }
            if (firstValue * 2 > num) {
                sb.append(firstKey).append("\n");
            } else {
                sb.append("SYJKGW").append("\n");
            }
        }
        System.out.print(sb);
    }
}