import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//강의실
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            lecture[num][0] = Integer.parseInt(st.nextToken());
            lecture[num][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lecture, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {

            if (!queue.isEmpty() && lecture[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(lecture[i][1]);
        }
        System.out.println(queue.size());
    }
}