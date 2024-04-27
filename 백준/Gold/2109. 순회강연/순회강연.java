import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] lecture = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken()); //p
            lecture[i][1] = Integer.parseInt(st.nextToken()); //d
        }
        Arrays.sort(lecture, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {

            queue.add(lecture[i][0]);
            if (queue.size() > lecture[i][1]) {
                queue.poll();
            }
        }
        int sum = 0;
        for (Integer i : queue) {
            sum += i;
        }
        System.out.println(sum);
    }
}