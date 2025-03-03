import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2290 LCD Test
public class Main {
    static char[][] num = {
            {'-', '|', '|', ' ', '|', '|', '-'},
            {' ', ' ', '|', ' ', ' ', '|', ' '},
            {'-', ' ', '|', '-', '|', ' ', '-'},
            {'-', ' ', '|', '-', ' ', '|', '-'},
            {' ', '|', '|', '-', ' ', '|', ' '},
            {'-', '|', ' ', '-', ' ', '|', '-'},
            {'-', '|', ' ', '-', '|', '|', '-'},
            {'-', ' ', '|', ' ', ' ', '|', ' '},
            {'-', '|', '|', '-', '|', '|', '-'},
            {'-', '|', '|', '-', ' ', '|', '-'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        // n을 s의 크기만큼 표시해야 한다. 각 숫자는 s+2의 가로와 2s+3의 세로로 이루어짐

        // 순서대로 1(위) 2(상단 좌우) 3(중간) 4(하단 좌우) 5(아래)
        top(n, 0, s);

        // 2
        height(s, n, 1, 2);

        // 3
        top(n, 3, s);

        // 4
        height(s, n, 4, 5);

        // 5
        top(n, 6, s);
    }

    static void top(String n, int x, int s) {
        for (int i = 0; i < n.length(); i++) {
            System.out.print(" " + String.valueOf(num[n.charAt(i) - '0'][x]).repeat(s) + " ");
            if (i < n.length() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static void height(int s, String n, int x, int x1) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n.length(); j++) {
                System.out.print(num[n.charAt(j) - '0'][x] + " ".repeat(s) + num[n.charAt(j) - '0'][x1]);
                if (j < n.length() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}