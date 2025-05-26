import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20164 홀수 홀릭 호석
public class Main {
    static int n, min = Integer.MAX_VALUE, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(n, oddCount(n)); // 홀수 개수
        System.out.println(min + " " + max);
    }

    static void dfs(int len, int cnt) {
        // 한자리면 종료
        if (len <= 9) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }

        // 두자리면 2개로 나눠서 합을 구해 새로운 수로 생각
        else if (len <= 99) {
            int sum = (len / 10) + (len % 10);
            dfs(sum, cnt + oddCount(sum));
        }

        // 세자리 이상이면 3개 수로 분할, 3개를 더한 값을 새로운 수
        else {
            String s = String.valueOf(len);
            for (int i = 0; i < s.length() - 2; i++) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    int t1 = Integer.parseInt(s.substring(0, i + 1));
                    int t2 = Integer.parseInt(s.substring(i + 1, j + 1));
                    int t3 = Integer.parseInt(s.substring(j + 1));
                    int sum = t1 + t2 + t3;
                    dfs(sum, cnt + oddCount(sum));
                }
            }
        }
    }

    static int oddCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n % 10) % 2 != 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}