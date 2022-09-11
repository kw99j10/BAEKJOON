import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); /*bufferreader로 정수형 입력 2개이상 받을 시 StringTokenizer- nextToken 사용*/

        int[] a = new int[n + 1]; /*누적 합 이용 위해 배열의 크기 n+1 */
        st = new StringTokenizer(br.readLine()); /*입력 후 줄 바꿈 필요 */

        a[0]=0;
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1]+Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); /*입력 후 줄 바꿈 필요 */
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); /*입력 후 줄 바꿈 필요 */
            int q=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            sb.append(a[w] - a[q - 1]).append("\n");
        }
        System.out.print(sb);
    }
}






