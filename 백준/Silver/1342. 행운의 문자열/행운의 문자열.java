import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1342 행운의 문자열
public class Main {
    static int len, count;
    static int[] arr;
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        len = s.length();
        result = new char[len];
        arr = new int[26];
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        perm(0);
        System.out.println(count);
    }

    static void perm(int idx) {
        if (idx == len) {
            boolean isPossible = true;
            for (int i = 1; i < len; i++) {
                if (result[i] == result[i - 1]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                count++;
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                arr[i] -= 1;
                result[idx] = (char) ('a' + i);
                perm(idx + 1);
                arr[i] += 1;
            }
        }
    }
}