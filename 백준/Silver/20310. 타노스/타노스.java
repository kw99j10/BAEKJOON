import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 20310 타노스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 문자 중 절반의 0과 1을 제거
        int oneCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            } else{
                oneCnt++;
            }
        }

        oneCnt = oneCnt / 2;
        zeroCnt = zeroCnt / 2;
        ArrayList<Integer> idx = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (oneCnt == cnt) {
                break;
            }
            if (s.charAt(i) == '1') {
                idx.add(i);
                cnt++;
            }
        }

        cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (zeroCnt == cnt) {
                break;
            }
            if (s.charAt(i) == '0') {
                idx.add(i);
                cnt++;
            }
        }

        Collections.sort(idx);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (idx.contains(i)) {
                continue;
            }
            answer.append(s.charAt(i));
        }
        System.out.println(answer);
    }
}