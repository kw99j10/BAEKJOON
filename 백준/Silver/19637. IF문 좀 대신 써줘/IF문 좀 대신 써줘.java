import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19637 IF문 좀 대신 써줘
public class Main {
    static class Title {
        String title;
        int power;

        public Title(String title, int power) {
            this.title = title;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Title[] title = new Title[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            title[i] = new Title(t, power);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int p = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (title[mid].power >= p) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(title[left].title).append("\n");
        }
        System.out.print(sb);
    }
}