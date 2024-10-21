import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 16922 로마 숫자 만들기
public class Main {
    static int[] num = {1, 5, 10, 50}; //로마 숫자
    static boolean[] total = new boolean[1001];

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        comb(0, 0, 0); //조합

        int count = 0;
        for (int i = 0; i < 1001; i++) {
            if (total[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void comb(int idx, int cnt, int sum) {
        if (cnt == n) {
            if (!total[sum]) {
                total[sum] = true;
            }
            return;
        }
        for (int i = idx; i < 4; i++) {
            comb(i, cnt + 1, sum + num[i]);
        }
    }
}