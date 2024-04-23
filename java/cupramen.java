import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//컵라면
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] cup = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cup[i][0]= Integer.parseInt(st.nextToken());
            cup[i][1]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cup, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(cup[i][1]);
            
            if (!queue.isEmpty() && queue.size() > cup[i][0]) {
                queue.poll(); //데드라인이 같다면 그 수가 더 많은 것을 선택 
            }
        }

        int sum = 0;
        for (Integer i : queue) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println(sum);
    }
}
