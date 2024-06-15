import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1057 토너먼트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());

        int round = 1;
        while (true) {
            if (kim % 2 == 0) {
                kim /= 2;
            } else {
                kim = kim / 2 + 1;
            }

            if (im % 2 == 0) {
                im /= 2;
            } else {
                im = im / 2 + 1;
            }

            if (kim == im) {
                break;
            }
            round++;
        }
        System.out.println(round);
    }
}