import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 28353 고양이 카페
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);

        boolean[] visit = new boolean[n];
        int count = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (!visit[left] && !visit[right] && k >= weight[left] + weight[right]) {
                visit[left] = visit[right] = true;
                count++;
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}