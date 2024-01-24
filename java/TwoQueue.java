package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//이중 우선순위 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            //중복 값을 계산하기 위해 우선순위 큐 -> TreeMap 구현
            //기본 정렬: 오름차순
            TreeMap<Integer, Integer> queue = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                //동일한 정수가 삽입될 수 있음을 고려
                if (!queue.isEmpty()) {

                    if (op.equals("D")) {
                        if (num == 1) {
                            int max = queue.lastKey();
                            if (queue.get(max) == 1) {
                                queue.remove(max);
                            }
                            else{
                                queue.put(max, queue.getOrDefault(max, 0) - 1);
                            }
                        } else if (num == -1) {
                            int min = queue.firstKey();
                            if (queue.get(min) == 1) {
                                queue.remove(min);
                            }
                            else{
                                queue.put(min, queue.getOrDefault(min, 0) - 1);
                            }
                        }
                    }
                }
                if (op.equals("I")) {
                    queue.put(num, queue.getOrDefault(num, 0) + 1);
                }
            }
            if (queue.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(queue.lastKey()).append(" ").append(queue.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
