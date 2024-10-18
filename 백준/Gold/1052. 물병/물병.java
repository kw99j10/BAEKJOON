import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1052 물병
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // n개의 물병으로 물이있는 물병의 수를 k개 이하로 만들기

        int min = 0; // 사야하는 물병의 최솟값

        while (true) {
            int current = n + min; //현재 물이있는 물병
            int count = 0;

            while (current > 0) {
                if (current % 2 != 0) {
                    count++;
                }
                current /= 2;
            }
            if (k >= count) {
                break;
            }
            min++;
        }
        System.out.println(min);
    }
}