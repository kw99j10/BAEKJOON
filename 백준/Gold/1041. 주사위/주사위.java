import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1041 주사위
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        long sum = 0L;
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, dice[i]);
            sum += dice[i];
        }

        if (n == 1) {
            System.out.println(sum - max);
            return;
        }

        int[] min = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = Math.min(dice[i], dice[5 - i]);
        }
        Arrays.sort(min);

        // 한 면만 보이는 경우
        long one = (long) (Math.pow(n - 2, 2) + (long) (n - 2) * (n - 1) * 4);
        long two = (n - 2) * 4L + (n - 1) * 4L;
        long three = (min[0] + min[1] + min[2]); // 꼭짓점 4개
        System.out.println(one * min[0] + two * (min[0] + min[1]) + three * 4);
    }
}