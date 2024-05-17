import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

//샘터
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //샘터의 위치
        int k = Integer.parseInt(st.nextToken()); //설치할 집의 개수

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>(); // 방문 배열 대체

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            queue.add(new int[]{tmp, 0});
            set.add(tmp);
        }

        long min = 0;
        int count = k;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int distance = current[1];

            for (int i = 0; i < 2; i++) {
                
                if (count == 0) {
                    break;
                }
                
                int nx = (i == 0) ? x + 1 : x - 1;
                if (!set.contains(nx)) {
                    count--;
                    min += distance + 1;
                    set.add(nx);
                    queue.add(new int[]{nx, distance + 1});
                }
            }
        }
        System.out.println(min);
    }
}