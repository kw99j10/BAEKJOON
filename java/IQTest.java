import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// IQ Test
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 2 && arr[0] == arr[1]) {
            System.out.println(arr[0]); //처음 두 수가 같다면 이후로 나올 수는 모두 같음
            return;
        }
        else if (n == 1 || n == 2) {
            System.out.println("A"); //1 or 2이면 다음에 올 수는 1개보다 많음 
            return;
        }
        for (int i = -200; i <= 200; i++) { //cf) 나올 수 있는 최대 범위 
            int tmp = arr[1] - arr[0] * i;

            int idx = 2;
            while (tmp == arr[idx] - arr[idx - 1] * i) {
                if (idx == n - 1) {
                    System.out.println(arr[n - 1] * i + tmp); //규칙이 있다면 현재 항의 다음 항을 계산하여 출력 
                    return;
                }
                idx++;
            }
        }
        System.out.println("B"); //규칙이 없어 다음 수를 구할 수 없음 
    }
}
