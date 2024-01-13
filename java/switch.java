import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        boolean[] visit = new boolean[n.length() + 1]; //1번부터 n번까지의 스위치

        //전구가 꺼져 있으면 true
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == 'N') {
                visit[i + 1] = true;
            }
        }

        int count = 0; //스위치를 누르는 횟수

        for (int i = 1; i < visit.length; i++) {
            if (visit[i]) {
                continue;
            }
            count += 1;
            for (int j = i; j < visit.length; j += i) {
                visit[j] = !visit[j];
            }
        }
        System.out.println(count);
    }
}
