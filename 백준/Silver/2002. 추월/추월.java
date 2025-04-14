import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 2002 추월
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> in = new HashMap<>(); // 터널 입구
        for (int i = 0; i < n; i++) {
            String car = br.readLine();
            in.put(car, i + 1);
        }

        int[] out = new int[n]; // 터널 출구
        for (int i = 0; i < n; i++) {
            out[i] = in.get(br.readLine());
        }

        int count = 0; // 추월한 차량의 수
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (out[i] > out[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}