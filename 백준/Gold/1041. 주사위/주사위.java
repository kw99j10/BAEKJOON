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

        int tSum = 0;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            tSum += dice[i];
            max = Math.max(max, dice[i]);
        }

        if (n == 1) {
            System.out.println(tSum - max);
            return; // 1인 경우 제외
        }

        int[] min = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = Math.min(dice[i], dice[5 - i]);
        }

        // 윗면 기준
        // 1. 3면이 보이는 주사위는 4개
        long sum = 0L;
        for (int i = 0; i < 3; i++) {
            sum += min[i];
        }
        sum *= 4;


        // 2. 2면이 보이는 주사위
        Arrays.sort(min);
        sum += (long) ((n - 2) * 8 + 4) * (min[0] + min[1]);
        sum += (long) (n - 2) * 4 * min[0];


        // 3. 1면만 보이는 주사위
        sum += (long) Math.pow(n - 2, 2) * 5 * min[0];
        System.out.println(sum);
    }
}