import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14696 딱지놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] a = new int[4];
            int[] b = new int[4];

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                a[Integer.parseInt(st.nextToken()) - 1]++;
            }

            st = new StringTokenizer(br.readLine());
            int num2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num2; j++) {
                b[Integer.parseInt(st.nextToken()) - 1]++;
            }

            if (a[3] != b[3]) {
                sb.append(a[3] > b[3] ? "A" : "B");
            } else if (a[2] != b[2]) {
                sb.append(a[2] > b[2] ? "A" : "B");
            } else if (a[1] != b[1]) {
                sb.append(a[1] > b[1] ? "A" : "B");
            } else if (a[0] != b[0]) {
                sb.append(a[0] > b[0] ? "A" : "B");
            } else {
                sb.append("D");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}