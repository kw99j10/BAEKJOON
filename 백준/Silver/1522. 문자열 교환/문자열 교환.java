import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1522 문자열 교환
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count = Integer.MAX_VALUE;
        int aCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        // a를 연속으로 만들려면 -> b를 옮겨야 함 -> a의 길이 안에 있는 b의 최소 개수 
        for (int i = 0; i < s.length(); i++) {
            int bCount = 0;
            for (int j = i; j < aCount + i; j++) {
                if (s.charAt(j % s.length()) == 'b') {
                    bCount++;
                }
            }
            count = Math.min(count, bCount);
        }
        System.out.println(count);
    }
}