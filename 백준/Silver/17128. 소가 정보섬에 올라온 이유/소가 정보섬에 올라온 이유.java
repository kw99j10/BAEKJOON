import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17128 소가 정보섬에 올라온 이유
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] cow = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cow[i] = Integer.parseInt(st.nextToken()); // 소 품질 점수
        }

        long[] sum = new long[n + 1];
        long total = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = cow[i];
            int idx = i + 1;
            for (int j = 0; j < 3; j++) {
                idx = idx > n ? idx % n : idx;
                sum[i] *= cow[idx++];
            }
            total += sum[i];
        }

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                total -= sum[num];
                sum[num] = -sum[num];
                total += sum[num];
                num--;
                num = num < 1 ? n : num;
            }
            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}
