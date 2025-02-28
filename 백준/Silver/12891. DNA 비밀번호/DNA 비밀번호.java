import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12891 dna 비밀 번호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        String dna = br.readLine();
        int[] answer = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        for (int i = 0; i < p; i++) {
            if (dna.charAt(i) == 'A') {
                count[0]++;
            } else if (dna.charAt(i) == 'C') {
                count[1]++;
            } else if (dna.charAt(i) == 'G') {
                count[2]++;
            } else {
                count[3]++;
            }
        }

        int total = 0;
        boolean isPossible = true;
        for (int i = 0; i < 4; i++) {
            if (answer[i] > count[i]) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            total++;
        }

        for (int i = p; i < s; i++) {
            int before = i - p;

            if (dna.charAt(before) == 'A') {
                count[0]--;
            } else if (dna.charAt(before) == 'C') {
                count[1]--;
            } else if (dna.charAt(before) == 'G') {
                count[2]--;
            } else {
                count[3]--;
            }


            if (dna.charAt(i) == 'A') {
                count[0]++;
            } else if (dna.charAt(i) == 'C') {
                count[1]++;
            } else if (dna.charAt(i) == 'G') {
                count[2]++;
            } else {
                count[3]++;
            }

            isPossible = true;
            for (int j = 0; j < 4; j++) {
                if (answer[j] > count[j]) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                total++;
            }
        }
        System.out.println(total);
    }
}