import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1003 피보나치 함수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] fiboZero = new int[41];
        int[] fiboOne = new int[41];

        fiboZero[0] = 1;
        fiboZero[1] = 0;

        fiboOne[0] = 0;
        fiboOne[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fiboOne[i] = fiboOne[i - 1] + fiboOne[i - 2];
            fiboZero[i] = fiboZero[i - 1] + fiboZero[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(fiboZero[num]).append(" ").append(fiboOne[num]).append("\n");
        }
        System.out.print(sb);
    }
}