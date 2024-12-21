import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1254 팰린드롬 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (isPalindrome(s)) {
            System.out.println(s.length());
            return;
        }

        int min = s.length(); // 최소 길이
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i);
            if (isPalindrome(tmp)) {
                min += i;
                break;
            }
        }
        System.out.println(min);
    }

    static boolean isPalindrome(String tmp) {
        int left = 0;
        int right = tmp.length() - 1;
        while (left < right) {
            if (tmp.charAt(left) != tmp.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
