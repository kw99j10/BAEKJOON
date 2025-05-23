import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2511 카드놀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] a = new int[10];
        int[] b = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        boolean isLastWinnerA = false;
        boolean isLastWinnerB = false;

        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] > b[i]) {
                aSum += 3;
                isLastWinnerA = true;
                isLastWinnerB = false;
            } else if (a[i] < b[i]) {
                bSum += 3;
                isLastWinnerB = true;
                isLastWinnerA = false;
            } else {
                aSum += 1;
                bSum += 1;
            }
        }

        System.out.println(aSum + " " + bSum);
        String winner;
        if (aSum == bSum) {
            if (!isLastWinnerA && !isLastWinnerB) {
                winner = "D";
            } else {
                winner = isLastWinnerA ? "A" : "B";
            }
        } else {
            winner = (aSum > bSum) ? "A" : "B";
        }
        System.out.println(winner);
    }
}