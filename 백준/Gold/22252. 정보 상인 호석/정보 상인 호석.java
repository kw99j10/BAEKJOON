import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 22252 정보 상인 호석
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 0L;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            // 고릴라가 없는 경우
            map.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
            PriorityQueue<Integer> pq = map.get(name);

            // 고릴라가 정보를 얻음
            if (num == 1) {
                for (int j = 0; j < count; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                map.put(name, pq);
            }

            // 호석이 정보 구매함
            else {
                if (!map.containsKey(name)) {
                    continue; // 고릴라 정보가 없는 경우
                }
                for (int j = 0; j < count; j++) {
                    if (!pq.isEmpty()) {
                        sum += pq.poll();
                    }
                }
            }
        }
        System.out.println(sum);
    }
}