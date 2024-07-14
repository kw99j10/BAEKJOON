import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//1747 소수&팰린드롬
public class Main {
    static final int TMP = 1100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[TMP + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(TMP); i++) {
            for (int j = i * i; j <= TMP; j += i) {
                isPrime[j] = false;
            }
        }
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 2; i <= TMP; i++) {
            if (!isPrime[i] || !isPalindrome(i)) {
                continue;
            }
            lists.add(i);
        }
        int n = Integer.parseInt(br.readLine());
        for (Integer list : lists) {
            if (list >= n) {
                System.out.println(list);
                break;
            }
        }
    }

    static boolean isPalindrome(int num) {
        String st = String.valueOf(num);
        for (int i = 0; i < st.length() / 2; i++) {
            char c = st.charAt(i);
            char d = st.charAt(st.length() - 1 - i);
            if (c != d) {
                return false;
            }
        }
        return true;
    }
}