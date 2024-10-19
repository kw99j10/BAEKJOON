import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 22233 가희와 키워드
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        } // 키워드

        // 쓴 글
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] tmp = br.readLine().split(",");
            for (String string : tmp) {
                set.remove(string);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.print(sb);
    }
}