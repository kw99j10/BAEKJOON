import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13164 행복 유치원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] min = new int[n - 1];
        for (int i = 1; i < n; i++) {
            min[i - 1] = cost[i] - cost[i - 1];
        }
        
        int sum = 0;
        Arrays.sort(min);
        for (int i = 0; i < n - k; i++) {
            sum += min[i];
        }
        System.out.println(sum);
    }
}