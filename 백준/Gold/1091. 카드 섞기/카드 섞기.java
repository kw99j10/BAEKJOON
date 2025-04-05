import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1091 카드 섞기
public class Main {
    static int[] p;
    static int[] s;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken()); // 초기 상태
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());  // 섞는 방식
        }
        int count = 0;
        while (!check()) { // 카드가 3의 배수인지 확인
            shuffle(); // 카드 섞기
            count++;
            if (count > 200000) {
                count = -1; // 섞어도 플레이어에게 줄 수 없음
                break;
            }
        }
        System.out.println(count);
    }

    static void shuffle() {
        int[] tmp = p.clone();
        for (int i = 0; i < n; i++) {
            p[s[i]] = tmp[i];
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if (p[i] != i % 3) {
                return false;
            }
        }
        return true;
    }
}