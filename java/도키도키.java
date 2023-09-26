import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        var s = new Stack<Integer>();
        int count = 1;
        for (int i = 1; i <= n; i++) {

            int k = sc.nextInt();

            if (count == k) {
                count += 1;
            }
            else {
                s.push(k);
            }
            while (!s.isEmpty() && s.peek() == count) {
                s.pop();
                count += 1; //순서 비교를 위한 스택 검사
            }
        }

        if (s.isEmpty()) {
            System.out.println("Nice");
        }
        else{
            System.out.println("Sad");
        }
    }
}
