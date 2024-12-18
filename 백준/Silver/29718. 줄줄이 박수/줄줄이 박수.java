import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 29718 줄줄이 박수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sum = new int[m]; // 열 누적합
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += arr[j][i];
            }
        }

        int a = Integer.parseInt(br.readLine());
        boolean isPossible = true;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = i; j < i + a; j++) {
                if (j >= m) {
                    isPossible = false;
                    break;
                }
                tmp += sum[j];
            }
            if (!isPossible) {
                break;
            }
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}
