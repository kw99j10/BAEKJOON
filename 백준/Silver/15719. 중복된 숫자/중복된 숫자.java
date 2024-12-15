import java.io.IOException;

// 15719 중복된 숫자
public class Main {
    static byte[] buffer = new byte[78888905];
    static int next;
    static int b;

    public static void main(String args[]) throws IOException {
        System.in.read(buffer, 0, buffer.length);
        long N = nextInt();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nextInt();
        }
        System.out.println(sum - (N * (N - 1) / 2));
    }

    static long nextInt() {
        long n = buffer[next++] - '0';
        while ((b = buffer[next++]) >= '0')
            n = (n * 10) + (b - '0');
        return n;
    }
}
