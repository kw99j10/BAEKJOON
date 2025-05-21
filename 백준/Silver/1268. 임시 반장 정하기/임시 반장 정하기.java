import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1268 임시 반장 정하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][0] == arr[j][0] || arr[i][1] == arr[j][1] || arr[i][2] == arr[j][2]
                        || arr[i][3] == arr[j][3] || arr[i][4] == arr[j][4]) {
                    count[i]++;
                }
            }
        }

        int max = 0;
        int minIdx = 1;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                minIdx = i + 1;
            }
        }
        System.out.println(minIdx);
    }
}