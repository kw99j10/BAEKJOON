import java.io.*;

// 17425 약수의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[1000001]; // 약수를 더한 값
        for (int i = 1; i <= 1000000; i++) {
            for (int j = i; j <= 1000000; j += i) {
                arr[j] += i;
            }
        }

        long[] sum = new long[1000001]; // 주어진 자연수까지의 누적합
        for (int i = 1; i <= 1000000; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(sum[num]).append("\n");
        }
        System.out.print(sb);
    }
}