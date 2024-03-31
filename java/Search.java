import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine(); //텍스트
        String p = br.readLine(); //패턴

        int n = t.length(); //텍스트 길이
        int m = p.length(); //패턴 문자열 길이

        int idx = 0; //패턴 문자열 포인터
        int[] skip = new int[m]; //패턴 문자열 전처리
        for (int i = 1; i < m; i++) {
            while (idx > 0 && p.charAt(i) != p.charAt(idx)) {
                idx = skip[idx - 1];
            }

            if (p.charAt(i) == p.charAt(idx)) {
                skip[i] = ++idx;
            }
        }

        idx = 0;
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (idx > 0 && t.charAt(i) != p.charAt(idx)) {
                idx = skip[idx - 1];
            }
            if (t.charAt(i) == p.charAt(idx)) {
                if (idx == p.length() - 1) {
                    idx = skip[idx];
                    lists.add(i - m + 2); //패턴 문자열과 일치하는 경우
                }
                else{
                    idx++;
                }
            }
        }
        System.out.println(lists.size());
        StringBuilder sb = new StringBuilder();
        for (Integer list : lists) {
            sb.append(list).append(" ");
        }
        System.out.print(sb);
    }
}
