import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21758 꿀 따기
public class Main {
    static int n;
    static int[] honey;
    static long[] front;
    static long[] back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        honey = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        front = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            front[i] = front[i - 1] + honey[i];
        }

        back = new long[n + 1];
        back[n] = honey[n];
        for (int i = n - 1; i >= 1; i--) {
            back[i] = back[i + 1] + honey[i];
        }
        System.out.println(Math.max(middle(), Math.max(right(), left())));
    }

    static long right() { // 1. 벌 벌 꿀통
        long max = 0;
        long first = front[n] - front[1]; // 첫번째 벌
        long second = front[n];
        for (int i = 2; i < n; i++) {
            long f = first - honey[i];
            long b = second - front[i];
            max = Math.max(max, f + b);
        }
        return max;
    }

    static long left() {  // 2. 꿀통 벌 벌
        long max = 0;
        long first = front[n] - honey[n];
        long second = front[n];
        for (int i = 2; i < n; i++) {
            long f = first - honey[i];
            long b = second - back[i];
            max = Math.max(max, f + b);
        }
        return max;
    }

    static long middle() {  // 3. 벌 꿀통 벌
        long max = 0;
        for (int i = 2; i < n; i++) {
            long f = front[i] - honey[1];
            long b = back[i] - honey[n];
            max = Math.max(max, f + b);
        }
        return max;
    }
}
