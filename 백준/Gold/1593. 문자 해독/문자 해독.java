import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1593 문자 해독
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken()); //W를 이루는 g의 길이
        int s = Integer.parseInt(st.nextToken()); //벽화에 기록된 마야 문자열의 길이 s

        String W = br.readLine(); // 문자열 W
        String S = br.readLine(); // 벽화의 마야 문자열 S

        int[] wAlpha = new int[52]; //w에 있는 알파벳
        int[] sAlpha = new int[52]; //s에 있는 알파벳

        for (int i = 0; i < g; i++) {
            char c = W.charAt(i);
            checkString(c, wAlpha);
        }

        int answer = 0;
        int start = 0;
        int end = 0; 
        
        //S 문자열에 W 부분 문자열이 있는지 슬라이딩 윈도우
        for (int i = 0; i < s; i++) {
            char c = S.charAt(i);
            checkString(c, sAlpha);
            end++;
            if (end == g) {
                if (Arrays.equals(wAlpha, sAlpha)) {
                    answer++;
                }
                if (S.charAt(start) >= 'a' && S.charAt(start) <= 'z') {
                    sAlpha[S.charAt(start) - 'a']--;
                } else {
                    sAlpha[S.charAt(start) - 'A' + 26]--;
                }
                start++;
                end--;
            }
        }
        System.out.println(answer);
    }

    private static void checkString(char c, int[] wAlpha) {
        if (c >= 'a' && c <= 'z') {
            wAlpha[c - 'a']++;
        }else{
            wAlpha[c - 'A' + 26]++;
        }
    }
}