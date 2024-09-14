import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15723 n단 논법
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] road = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(road[i], 999999);
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" is ");
            road[(int) s[0].charAt(0) - 97][(int) s[1].charAt(0) - 97] = 1;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String []s = br.readLine().split(" is ");
            if (road[(int) s[0].charAt(0) - 97][(int) s[1].charAt(0) - 97] != 999999) {
                sb.append("T");
            } else {
                sb.append("F");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}